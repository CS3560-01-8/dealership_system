package dealership.controller;

import dealership.access.*;
import dealership.object.Employee;
import dealership.object.Sale;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SaleHandler {

    private static ArrayList<Employee> employeesBesidesLoggedIn;
    private static Sale pendingSale;

    public static void startSale(float agreedPrice, float tax, String cardNum, String customerEmail, ArrayList<Employee> allSaleEmployees) {
        pendingSale = new Sale(VehicleHandler.getSelectedVehicle(), agreedPrice, tax, cardNum, AccountDB.getCustomerWithoutAppointments(customerEmail), allSaleEmployees);
    }

    public static void finalizeSale() {
        ((Employee) AccountHandler.getLoggedInAccount()).addSale(pendingSale);
        pendingSale = null;
    }

    public static Sale getSale() {
        return pendingSale;
    }

    public static void loadEmployeesIntoList(JPanel listOtherEmployees) {
        employeesBesidesLoggedIn = AccountDB.getAllEmployeesBesides(AccountHandler.getLoggedInEmail());
        listOtherEmployees.setLayout(new GridLayout(0, 1));
        for (Employee employee : employeesBesidesLoggedIn) {
            JCheckBox checkBox = new JCheckBox(employee.getName() + " (" + employee.getRole() + ")");
            checkBox.setFont(new java.awt.Font("Segoe UI", 0, 14));
            listOtherEmployees.add(checkBox);
        }
    }

    public static ArrayList<Employee> getEmployeesInSale(JPanel listOtherEmployees) {
        ArrayList<Employee> employeesInSale = new ArrayList<>();
        employeesInSale.add((Employee) AccountHandler.getLoggedInAccount());
        for (int i = 0; i < listOtherEmployees.getComponents().length; i++) {
            if (((JCheckBox) listOtherEmployees.getComponents()[i]).isSelected()) {
                employeesInSale.add(employeesBesidesLoggedIn.get(i));
            }
        }
        return employeesInSale;
    }

}
