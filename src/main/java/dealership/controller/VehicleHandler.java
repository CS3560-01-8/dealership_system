package dealership.controller;

import dealership.object.Vehicle;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VehicleHandler {

    private static ArrayList<Vehicle> loadedVehicles;

    public static void loadVehiclesInTable(DefaultTableModel model) {
        loadedVehicles = Vehicle.getAvailableVehicles();
        for (Vehicle loadedVehicle : loadedVehicles) {
            model.addRow(loadedVehicle.getRowData());
        }
    }

}
