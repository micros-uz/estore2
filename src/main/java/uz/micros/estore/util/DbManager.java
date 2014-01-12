package uz.micros.estore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    public static String connectToDb() {
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            return "Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!";
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {
/*            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/estore", "postgres",
                    "dev1234");*/

            String host = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
            String port = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":" + port + "/estore", "adminn8szx56",
                    "yqAhZ7uXKt6Y");

        } catch (SQLException e) {
            return "Connection Failed! Check output console " + e.getMessage();
        }

        if (connection != null)
            return "You made it, take control your database now!";
        else
            return "Failed to make connection!";
    }
}
