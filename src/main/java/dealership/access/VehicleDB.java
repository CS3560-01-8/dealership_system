package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDB {

    public static ArrayList<Vehicle> getAvailableVehicles(String whereClause) {
        ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM vehicle " + whereClause);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            while (res.next()) {
                vehicles.add(new Vehicle(res.getString("vin"), res.getString("make"), res.getString("model"),
                        res.getInt("year"), res.getString("style"), res.getString("color"),
                        res.getInt("mileage"), res.getInt("listing_price"), res.getBoolean("sold")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public static ArrayList<String> getStyles() {
        return executeQueryIntoList("SELECT DISTINCT style from dealership.vehicle WHERE sold = '0' ORDER BY style");
    }

    public static ArrayList<String> getMakes() {
        return executeQueryIntoList("SELECT DISTINCT make from dealership.vehicle WHERE sold = '0' ORDER BY make");
    }

    public static ArrayList<String> getModels(String make) {
        return executeQueryIntoList("SELECT DISTINCT model from dealership.vehicle WHERE sold = '0' AND make = '" + make + "' ORDER BY model");
    }

    public static ArrayList<String> getColors() {
        return executeQueryIntoList("SELECT DISTINCT color from dealership.vehicle WHERE sold = '0' ORDER BY color");
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

    public static boolean isVinValid(String vin) {
        String query = "SELECT 1 FROM vehicle WHERE vin = '" + vin + "' AND sold = '0'";
        try {
            ResultSet res = DatabaseConnector.executeQuery(query);
            if (res.next()) {
                System.out.println("car found!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("car not found!");
        return false;
    }

    public static Vehicle getVehicleByVin(String vin) {
        String make = "";
        String model = "";
        int year = 0;
        String style = "";
        String color = "";

        try {
            ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM vehicle WHERE vin = '" + vin + "' AND sold = '0'");
            if (res.next()) {
                make = res.getString("make");
                model = res.getString("model");
                year = res.getInt("year");
                style = res.getString("style");
                color = res.getString("color");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Vehicle(vin, make, model, year, style, color, 0, 0, false);
    }

    public static void carSold(String vin) {
        if (isVinValid(vin)) {
            String query = "UPDATE dealership.vehicle SET sold = 1 WHERE vin = '" + vin + "'";
            DatabaseConnector.executeInsert(query);
        }
    }
}
