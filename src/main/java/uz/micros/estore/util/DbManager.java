package uz.micros.estore.util;

import javafx.util.Pair;

import java.sql.*;

public class DbManager {
    public static Pair<String, Connection> connectToDb() {
        String res1 = null;
        Connection res2 = null;

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            res1 = "Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!";
        }

        if (res1 == null) {
            System.out.println("PostgreSQL JDBC Driver Registered!");

            try {
                String host = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
                String port = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");

                if (host == null) {
                    res2 = DriverManager.getConnection(
                            "jdbc:postgresql://127.0.0.1:5432/estore", "postgres",
                            "dev1234");
                } else {
                    res2 = DriverManager.getConnection(
                            "jdbc:postgresql://" + host + ":" + port + "/estore", "adminn8szx56",
                            "yqAhZ7uXKt6Y");
                }

            } catch (SQLException e) {
                res1 = "Connection Failed! Check output console " + e.getMessage();
            }

            if (res2 != null)
                res1 = " You made it, take control your database now!";
            else
                res1 = " Failed to make connection!";
        }

        return new Pair<>(res1, res2);
    }

    public static String runQuery(String query) {
        Pair<String, Connection> res = connectToDb();

        if (res.getValue() != null) {
            try{
                Statement st = res.getValue().createStatement();
                ResultSet rs = st.executeQuery(query);

                return rs.toString();
            }
            catch(SQLException ex){
                return ex.getMessage();
            }
        } else
            return res.getKey();
    }
}
