package dealership.db;

import java.sql.*;

public class DatabaseConnector {

    private static Connection conn;

    public static void createConnection(String password) {
        try {
            System.out.println("Connecting to database..");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership", "root", password);
            System.out.println("Database connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        ResultSet result = null;
        try {
            //For debugging purposes
            System.out.println("Query: " + query);
            Statement statement = conn.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void executeInsert(String query) {
        try {
            System.out.println(query);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean tableContainsRow(String table, String attribute, String value) {
        try {
            ResultSet res = DatabaseConnector.executeQuery(String.format("SELECT 1 FROM %s WHERE %s = '%s'", table, attribute, value));
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
