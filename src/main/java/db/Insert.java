package db;

import user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert {
    public static User addUserToAuthentication(String name, String email, String password) {
        try {
            Connection connection = JDBC.connect();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO AUTHENTICATION VALUES(?,?,?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
            statement.close();
            connection.close();
            return new User(name, email, password);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
}
