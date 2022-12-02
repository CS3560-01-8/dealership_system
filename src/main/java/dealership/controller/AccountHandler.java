package dealership.controller;

import dealership.access.AccountDB;
import dealership.object.Account;
import dealership.object.Appointment;
import dealership.object.Customer;
import dealership.object.Employee;

import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AccountHandler {

    // logged in account
    private static Account loggedInAccount;

    // create and save customer account to database
    public static boolean createCustomerAccount(String email, String password, String firstName, String lastName, String phoneNum, String address) {
        if (Customer.exists(email)) {
            return false;
        }
        //TODO fix direct call to DB with Customer object?
        AccountDB.writeCustomer(new Customer(email, firstName, lastName, phoneNum, address, new ArrayList<>()), password);
        return true;
    }

    // test if login is valid; true if so, false otherwise
    public static boolean tryLogin(String email, String password) {
        loggedInAccount = Account.getAccount(email, password);
        return isLoggedIn();
    }

    // test if user is logged into an account; true if so, false otherwise
    public static boolean isLoggedIn() {
        return loggedInAccount != null;
    }

    // get name of logged in user
    public static String getLoggedInName() {
        return loggedInAccount.getName();
    }

    // get email of logged in user
    public static String getLoggedInEmail() { return loggedInAccount.getEmail(); }

    // test if account is for an employee
    public static boolean isEmployee()
    {
        return (loggedInAccount instanceof Employee);
    }

    // list to convert month's name into an int
    private static final HashMap<String, Integer> monthToInt = new HashMap<String, Integer>() {
        {
            put("January", 1);
            put("February", 2);
            put("March", 3);
            put("April", 4);
            put("May", 5);
            put("June", 6);
            put("July", 7);
            put("August", 8);
            put("September", 9);
            put("October", 10);
            put("November", 11);
            put("December", 12);
        }
    };

    public static String formatTime(String month, String date, String time) {
        String startTime = time.substring(0, time.indexOf("-"));
        int hour = Integer.parseInt(startTime.substring(0, startTime.indexOf(":")));
        String min = time.substring(startTime.indexOf(":") + 1, startTime.indexOf(" "));
        hour += !startTime.contains("P") || hour == 12 ? 0 : 12;
        String dateStr = Integer.parseInt(date) < 10 ? "0" + date : date;
        String hourStr = hour < 10 ? "0" + hour : hour + "";
        return Year.now().getValue() + "-" + monthToInt.get(month) + "-" + dateStr + " " + hourStr + ":" + min + ":00";
    }

    public static boolean isTimeValid(String time){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date currentTime = new Date();
        Date appointmentTime = null;
        try{
            appointmentTime = formatter.parse(time);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return currentTime.compareTo(appointmentTime) < 0;
    }

    public static boolean tryMakeAppointment(String vin, String dateTime) {
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

}