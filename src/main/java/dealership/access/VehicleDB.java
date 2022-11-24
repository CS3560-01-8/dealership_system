package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDB {

    public static ArrayList<Vehicle> getAvailableVehicles() {
        return getAvailableVehicles("", "");
    }

    public static ArrayList<Vehicle> getAvailableVehicles(String make) {
        return getAvailableVehicles(make, "");
    }

    public static ArrayList<Vehicle> getAvailableVehicles(String make, String model) {
        String query = "SELECT * FROM vehicle WHERE sold = '0'";
        if (!make.isEmpty()) {
            query += " AND make = '" + make + "'";
        }
        if (!model.isEmpty()) {
            query += " AND model = '" + model + "'";
        }

        ResultSet res = DatabaseConnector.executeQuery(query);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            while (res.next()) {
                vehicles.add(new Vehicle(res.getString("vin"), res.getString("make"),
                        res.getString("model"), res.getInt("year"),
                        res.getString("condition"), res.getInt("mileage"),
                        res.getInt("listing_price"), res.getBoolean("sold")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public static ArrayList<String> getMakes() {
        return executeQueryIntoList("SELECT DISTINCT make from dealership.vehicle WHERE sold = '0' ORDER BY make");
    }

    public static ArrayList<String> getModels(String make) {
        return executeQueryIntoList("SELECT DISTINCT model from dealership.vehicle WHERE sold = '0' AND make = '" + make + "' ORDER BY model");
    }

    private static ArrayList<String> executeQueryIntoList(String query) {
        ArrayList<String> results = new ArrayList<>();
        ResultSet res = DatabaseConnector.executeQuery(query);
        try {
            while (res.next()) {
                results.add(res.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

}
