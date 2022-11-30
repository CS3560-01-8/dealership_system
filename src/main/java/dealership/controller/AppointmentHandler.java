package dealership.controller;

import dealership.access.AppointmentDB;
import dealership.object.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AppointmentHandler {
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
        if (AppointmentDB.checkAvailability(email, vin, dateTIme)) {
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
}
