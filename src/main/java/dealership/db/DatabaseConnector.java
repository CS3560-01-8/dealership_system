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
            Statement statement = conn.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



}
