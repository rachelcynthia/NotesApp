package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    static Connection connect(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/notesapp",
                            "notesapp", "password");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Connected to database successfully");
        return connection;
    }
}
