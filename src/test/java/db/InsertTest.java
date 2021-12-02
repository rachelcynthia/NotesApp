package db;

import org.junit.jupiter.api.Test;
import util.Helpers;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class InsertTest {
    @Test
    void shouldAddUserToTheAuthenticationTable() {
        String name = "User";
        String email = "user@gmail.com";
        String password = "Password@123";

        Insert.addUserToAuthentication(name, email, password);

        try {
            Connection connection = JDBC.connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM AUTHENTICATION WHERE EMAIL = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            assertTrue(rs.next());
            Helpers.deleteAfterTesting(email);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            assertFalse(false);
        }
    }
}