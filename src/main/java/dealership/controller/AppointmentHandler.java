package dealership.controller;

import dealership.access.AppointmentDB;
import dealership.object.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class AppointmentHandler {
    
    // list of appointments
    private static ArrayList<Appointment> appts;
    // index of selected appointment
    private static int selectedIndex = -1;
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

    public static boolean makeAppointment(String email, String vin, String dateTIme) {
        if (AppointmentDB.isAppointmentValid(email, vin, dateTIme)) {
            AppointmentDB.writeAppointment(new Appointment(email, vin, dateTIme));
            return true;
        }
        return false;
    }


    public static String formatTime(String month, String date, String time) {
        String startTime = time.substring(0, time.indexOf("-"));
        int hour = Integer.parseInt(startTime.substring(0, startTime.indexOf(":")));
        String min = time.substring(startTime.indexOf(":") + 1, startTime.indexOf(" "));
        hour += !startTime.contains("P") || hour == 12 ? 0 : 12;
        return Year.now().getValue() + "-" + monthToInt.get(month) + "-" + date + " " + hour + ":" + min;
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

    public static ArrayList<Appointment> getLoggedInCustomerAppointments(){
        if(AccountHandler.isLoggedIn())
            return AppointmentDB.getAppointments(AccountHandler.getLoggedInEmail());
        return null;
    }
    
    // load all appointments for a specific customer onto table
    public static void loadAppointmentsIntoTable(DefaultTableModel tableModel) {
        appts = getLoggedInCustomerAppointments();
        tableModel.setRowCount(0);
        Object[] rowData = new Object[2];
        if (appts != null) {
            for (Appointment a : appts) {
                rowData[0] = a.getDateTime();
                rowData[1] = a.getVin();
                tableModel.addRow(rowData);
            }
        } else {
            rowData[0] = "No appointments created";
            tableModel.addRow(rowData);
        }
    }
    
    // load all appointments onto table
    public static void loadAllAppointmentsIntoTable(DefaultTableModel tableModel) {
        appts = AppointmentDB.getAllAppointments();
        tableModel.setRowCount(0);
        Object[] rowData = new Object[3];
        if (appts != null) {
            for (Appointment a : appts) {
                rowData[0] = a.getCustomerEmail();
                rowData[1] = a.getDateTime();
                rowData[2] = a.getVin();
                tableModel.addRow(rowData);
            }
        } else {
            rowData[0] = "No appointments created";
            tableModel.addRow(rowData);
        }
    }
    
    // set selected item
    public static void selectAppointment(int index) {
        if (index >= 0 && index < appts.size()) {
            selectedIndex = index;
        }
    }
    
    // get selected item
    private static Appointment getSelectedAppointment() {
        return appts.get(selectedIndex);
    }
    
    // delete selected item
    public static void removeAppointmentFromTable(DefaultTableModel tableModel) {
        if (appts != null) {
            AppointmentDB.deleteAppointment(getSelectedAppointment().getCustomerEmail(), getSelectedAppointment().getVin());
            tableModel.removeRow(selectedIndex);
        }
    }
}
