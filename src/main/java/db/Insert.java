package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert {
    static void addUserToAuthentication(String name, String email, String password){
        try {
            Connection connection = JDBC.connect();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO AUTHENTICATION VALUES(?,?,?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
