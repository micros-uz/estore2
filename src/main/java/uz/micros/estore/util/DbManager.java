package uz.micros.estore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

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
        String envs = "";

        try {
/*            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/estore", "postgres",
                    "dev1234");*/


            Map<String, String> env = System.getenv();
            for (String envName : env.keySet()) {
                envs += String.format("%s=%s%n", envName, env.get(envName));
            }

            String host = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
            String port = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
            host = "127.4.127.2";
            port = "5432";
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":" + port + "/estore", "adminn8szx56",
                    "yqAhZ7uXKt6Y");

        } catch (SQLException e) {
            return "Connection Failed! Check output console " + e.getMessage();
        }

        if (connection != null)
            return envs + " You made it, take control your database now!";
        else
            return envs + " Failed to make connection!";
    }
}
