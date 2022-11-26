package dealership.controller;

import dealership.object.Appointment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentHandler {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static boolean makeAppointment(String email, String vin, String dateTIme) {
        if (!Appointment.vinExist(vin)) {
            System.out.println("vin does not exist! try again!");
            return false;
        }

        new Appointment(email, vin, dateTIme);
        return true;
    }

    public static String DateTimeToString(LocalDateTime time) {
        return time.format(formatter);
    }

    public static LocalDateTime StringToDateTime(String time) {
        return LocalDateTime.parse(time, formatter);
    }
}
