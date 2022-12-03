package dealership.controller;

import dealership.access.*;
import dealership.object.Commission;
import dealership.object.Employee;
import dealership.object.Sale;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SaleHandler {

    private static ArrayList<Employee> employeesBesidesLoggedIn;

    public static boolean makeSale(String vin, float agreedPrice, float tax, String cardNum){
        if(!VehicleDB.isVinValid(vin)) return false;
        SaleDB.writeSale(new Sale(vin, agreedPrice, tax, cardNum));
        return true;
    }
    public static boolean makeCommission(Sale sale)
    {
        if(!SaleDB.isSaleValid(sale.getVin()))
        {
            return false;
        }
        CommissionDB.writeCommissions(sale.getCommission());
        return true;
    }

    public static void loadEmployeesIntoList(JPanel listOtherEmployees) {
        employeesBesidesLoggedIn = AccountDB.getAllEmployeesBesides(AccountHandler.getLoggedInEmail());
        listOtherEmployees.setLayout(new GridLayout(0, 1));
        for (Employee employee : employeesBesidesLoggedIn) {
            listOtherEmployees.add(new JCheckBox(employee.getName() + " (" + employee.getRole() + ")"));
        }
    }

    private static ArrayList<Employee> getEmployeesInSale(JPanel listOtherEmployees) {
        //TODO implement
        return null;
    }

}
