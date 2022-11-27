package dealership.object;


import java.util.ArrayList;

public class Customer extends Account {

    private final String address;

    private ArrayList<Appointment> appointments = null;

    public Customer(String email, String firstName, String lastName, String phoneNum, String address) {
        super(email, firstName, lastName, phoneNum);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}