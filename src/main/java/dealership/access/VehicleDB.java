package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDB {

    public static ArrayList<Vehicle> getAvailableVehicles() {
        ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM vehicle WHERE sold = '0'");
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

}
