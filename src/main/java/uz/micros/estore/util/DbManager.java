package uz.micros.estore.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbManager {
    public static Connection connectToDb() {
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

        //if (res1 != null) throw new SQLException(res1);

        return res2;
    }

    public static List<Map<String, Object>> runQuery(String query) {
        Connection conn = connectToDb();
        List<Map<String, Object>> list = null;
        String err = null;

        if (conn != null) {
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);

                list = parseResultSet(rs);
            }
            catch(SQLException ex){
                err = ex.getMessage();
            }
        } else
            err = "Connection create failed";

        return list;
    }

    private static List<Map<String, Object>> parseResultSet(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> rows = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> columns = new LinkedHashMap<String, Object>();

            for (int i = 1; i <= columnCount; i++) {
                columns.put(metaData.getColumnLabel(i), resultSet.getObject(i));
            }

            rows.add(columns);
        }

        return rows;
    }
}
