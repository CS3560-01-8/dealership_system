package dealership.controller;

import dealership.access.VehicleDB;
import dealership.object.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class VehicleHandler {

    private static ArrayList<Vehicle> loadedVehicles;
    private static int selectedIndex = -1;

    public static void loadVehiclesIntoTable(DefaultTableModel tableModel, String make, String model) {
        if (make.equals("Any")) {
            loadedVehicles = VehicleDB.getAvailableVehicles();
        } else if (model.equals("Any")) {
            loadedVehicles = VehicleDB.getAvailableVehicles(make);
        } else {
            loadedVehicles = VehicleDB.getAvailableVehicles(make, model);
        }
        tableModel.setRowCount(0);
        for (Vehicle loadedVehicle : loadedVehicles) {
            tableModel.addRow(loadedVehicle.getRowData());
        }
    }

    public static void loadMakesIntoComboBox(JComboBox<String> comboBox) {
        ArrayList<String> makes = VehicleDB.getMakes();
        makes.add(0, "Any");
        comboBox.setModel(new DefaultComboBoxModel<>(new Vector<>(makes)));
    }

    public static void loadModelsIntoComboBox(JComboBox<String> comboBox, String make) {
        ArrayList<String> models = VehicleDB.getModels(make);
        models.add(0, "Any");
        comboBox.setModel(new DefaultComboBoxModel<>(new Vector<>(models)));
    }

    public static void selectVehicle(int index) {
        selectedIndex = index;
    }

    public static Vehicle getSelectedVehicle() {
        if (selectedIndex < 0 || selectedIndex >= loadedVehicles.size()) {
            return null;
        }
        return loadedVehicles.get(selectedIndex);
    }

}
