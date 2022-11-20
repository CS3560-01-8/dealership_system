package dealership.object;

import dealership.access.AccountDB;

public class Customer extends Account {
    private String address;

    public Customer(String email, String password, String firstName, String lastName, String phoneNum, String address) {
        super(email, password, firstName, lastName, phoneNum);
        this.address = address;
        AccountDB.write(this);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static boolean exists(String email) {
        return false;
    }
}