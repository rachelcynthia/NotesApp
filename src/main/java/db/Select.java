package db;

import user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
    public static User selectFromAuthentication(String email, String password) {
        try {
            Connection connection = JDBC.connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM AUTHENTICATION WHERE EMAIL = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String correctPassword = resultSet.getString("password");
                String name = resultSet.getString("name");
                if (correctPassword.equals(password)) {
                    statement.close();
                    connection.close();
                    return new User(name, email, password);
                }
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
