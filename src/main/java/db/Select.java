package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
    public static boolean selectFromAuthentication(String email, String password) {
        try {
            Connection connection = JDBC.connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM AUTHENTICATION WHERE EMAIL = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String correctPassword = resultSet.getString("password");
                if (correctPassword.equals(password)) {
                    statement.close();
                    connection.close();
                    return true;
                }
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }
}
