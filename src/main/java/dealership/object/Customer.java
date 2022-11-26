package dealership.object;


public class Customer extends Account {

    private final String address;

    public Customer(String email, String firstName, String lastName, String phoneNum, String address) {
        super(email, firstName, lastName, phoneNum);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}