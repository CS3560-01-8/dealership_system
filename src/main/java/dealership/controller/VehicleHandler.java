package dealership.controller;

import dealership.access.VehicleDB;
import dealership.object.Vehicle;
import dealership.util.VehicleFilter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class VehicleHandler {

    private static ArrayList<Vehicle> loadedVehicles;
    private static int selectedIndex = -1;
    private static final VehicleFilter filter = new VehicleFilter();

    public static void loadVehiclesIntoTable(DefaultTableModel tableModel) {
        loadedVehicles = Vehicle.getAvailableVehicles(filter);
        tableModel.setRowCount(0);
        for (Vehicle loadedVehicle : loadedVehicles) {
            tableModel.addRow(loadedVehicle.getRowData());
        }
    }

    public static void loadStylesIntoComboBox(JComboBox<String> comboBox) {
        ArrayList<String> styles = VehicleDB.getStyles();
        styles.add(0, "Any");
        comboBox.setModel(new DefaultComboBoxModel<>(new Vector<>(styles)));
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

    public static void loadColorsIntoComboBox(JComboBox<String> comboBox) {
        ArrayList<String> colors = VehicleDB.getColors();
        colors.add(0, "Any");
        comboBox.setModel(new DefaultComboBoxModel<>(new Vector<>(colors)));
    }

    public static void selectVehicle(int index) {
        if (index >= 0 && index < loadedVehicles.size()) {
            selectedIndex = index;
        }
    }

    public static VehicleFilter getFilter() {
        return filter;
    }

    public static String getSelectedVehicleVin() {
        return getSelectedVehicle().getVin();
    }

    public static String getSelectedVehicleDetails() {
        return getSelectedVehicle().toString();
    }

    public static String getSelectedVehicleListingPrice() {
        return "$" + getSelectedVehicle().getListingPrice();
    }

    protected static Vehicle getSelectedVehicle() {
        return loadedVehicles.get(selectedIndex);
    }
}
