package dealership.object;


import java.util.ArrayList;

public class Customer extends Account {

    private final String address;

    private ArrayList<Appointment> appointments = null;

    public Customer(String email, String firstName, String lastName, String phoneNum, String address, ArrayList<Appointment> appointments) {
        super(email, firstName, lastName, phoneNum);
        this.address = address;
        this.appointments = appointments;
    }

    public String getAddress() {
        return address;
    }

    public void addAppointments(ArrayList<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            this.appointments.add(appointment);
        }
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    ;

}