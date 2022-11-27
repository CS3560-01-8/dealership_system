package dealership.controller;

import dealership.access.AppointmentDB;
import dealership.object.Appointment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentHandler {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static boolean makeAppointment(String email, String vin, String dateTIme) {
        if(AppointmentDB.checkAvailability(email,vin,dateTIme)){
            AppointmentDB.write(new Appointment(email, vin, dateTIme));
            return true;
        }
        return false;
    }

    public static String DateTimeToString(LocalDateTime time) {
        return time.format(formatter);
    }

    public static LocalDateTime StringToDateTime(String time) {
        return LocalDateTime.parse(time, formatter);
    }
}
