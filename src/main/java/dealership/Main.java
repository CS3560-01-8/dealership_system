package dealership;

import dealership.db.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide your MYSQL password as the first command line argument.");
            System.exit(1);
        }
        DatabaseConnector.createConnection(args[0]);

        //Example query
        ResultSet rs = DatabaseConnector.executeQuery("SELECT * FROM sale");
        System.out.println("Sales Table:");
        try {
            while (rs.next()) {
                for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
