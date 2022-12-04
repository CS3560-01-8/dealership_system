package dealership.object;

import dealership.access.AppointmentDB;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Customer extends Account {

    private final String address;
    private final ArrayList<Appointment> appointments;

    public Customer(String email, String firstName, String lastName, String phoneNum, String address, ArrayList<Appointment> appointments) {
        super(email, firstName, lastName, phoneNum);
        this.address = address;
        this.appointments = appointments;
    }

    public String getAddress() {
        return address;
    }

    public boolean tryAddAppointment(String vin, LocalDateTime dateTime) {
        if (AppointmentDB.isAppointmentValid(super.getEmail(), vin, dateTime)) {
            Appointment appointment = new Appointment(super.getEmail(), vin, dateTime);
            appointments.add(appointment);
            AppointmentDB.writeAppointment(appointment);
            return true;
        }
        return false;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void removeAppointment(int selectedAppointmentIndex) {
        AppointmentDB.deleteAppointment(super.getEmail(), appointments.get(selectedAppointmentIndex).getVin());
        appointments.remove(selectedAppointmentIndex);
    }

    public boolean hasMadeAppointment(String vin) {
        for (Appointment appointment : appointments) {
            if (appointment.getVin().equals(vin)) {
                return true;
            }
        }
        return false;
    }
}