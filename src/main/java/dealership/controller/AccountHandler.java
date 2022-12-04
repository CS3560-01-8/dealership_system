package dealership.controller;

import dealership.access.AccountDB;
import dealership.object.*;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountHandler {

    private static Account loggedInAccount;

    public static boolean createCustomerAccount(String email, String password, String firstName, String lastName, String phoneNum, String address) {
        if (Customer.exists(email)) {
            return false;
        }
        //TODO fix direct call to DB with Customer object?
        AccountDB.writeCustomer(new Customer(email, firstName, lastName, phoneNum, address, new ArrayList<>()), password);
        return true;
    }

    public static boolean customerExists(String email) {
        return Customer.exists(email);
    }

    public static boolean tryLogin(String email, String password) {
        loggedInAccount = Account.getAccount(email, password);
        return isLoggedIn();
    }

    public static void tryLogout(){
        loggedInAccount = null;
    }

    public static boolean isLoggedIn() {
        return loggedInAccount != null;
    }

    public static String getLoggedInName() {
        return loggedInAccount.getName();
    }

    public static String getLoggedInEmail() { return loggedInAccount.getEmail(); }

    protected static Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public static boolean isEmployee()
    {
        return (loggedInAccount instanceof Employee);
    }

    public static LocalDateTime formatDateTime(String date, String time) {
        return LocalDateTime.parse(date + " " + LocalDate.now().getYear() + " " + time.substring(0, 8),
                DateTimeFormatter.ofPattern("EEEE, MMM d y hh:mm a", Locale.ENGLISH));
    }

    public static boolean tryMakeAppointment(String vin, LocalDateTime dateTime) {
        return ((Customer) loggedInAccount).tryAddAppointment(vin, dateTime);
    }

    public static void loadAppointmentsIntoTable(DefaultTableModel tableModel) {
        ArrayList<Appointment> appointments = ((Customer) loggedInAccount).getAppointments();
        tableModel.setRowCount(0);

        for (Appointment appointment : appointments) {
            tableModel.addRow(appointment.getRowData());
        }
        if (appointments.isEmpty()) {
            tableModel.addRow(new Object[] {"No appointments created"});
        }
    }

    public static void deleteAppointment(int index) {
        ((Customer) loggedInAccount).removeAppointment(index);
    }

    public static boolean hasMadeAppointmentWithVehicle(String vin) {
        return ((Customer) loggedInAccount).hasMadeAppointment(vin);
    }

    public static void loadSalesIntoTable(DefaultTableModel tableModel) {
        ArrayList<Sale> sales = ((Employee) loggedInAccount).getSales();

        for (Sale sale : sales) {
            tableModel.addRow(sale.getRowData((Employee) loggedInAccount));
        }

        if (sales.isEmpty()) {
            tableModel.addRow(new Object[] {"No sales"});
        }
    }
}