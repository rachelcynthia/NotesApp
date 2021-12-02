package util;

import db.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Helpers {
    public static void deleteAfterTesting(String email) {
        try {
            Connection connection = JDBC.connect();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM AUTHENTICATION WHERE EMAIL = ?");
            statement.setString(1, email);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
