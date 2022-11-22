package dealership.controller;

import dealership.object.Appointment;

public class AppointmentHandler {
    public static boolean makeAppointment(String email, String vin, String dateTIme){
        if(!Appointment.vinExist(vin))
        {
            System.out.println("vin does not exist! try again!");
            return false;
        }

        new Appointment(email, vin, dateTIme);
        return true;
    }
}
