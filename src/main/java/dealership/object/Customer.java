package dealership.object;

class Customer extends Account {
    private String address;

    public Customer(String email, String password, String name, String phoneNum, String address) {
        super(email, password, name, phoneNum);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}