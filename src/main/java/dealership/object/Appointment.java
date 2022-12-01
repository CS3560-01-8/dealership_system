package dealership.object;

public class Appointment {

    private String customerEmail;
    private String vin;
    private String dateTime;

    public Appointment(String customerEmail, String vin, String dateTime) {
        this.customerEmail = customerEmail;
        this.vin = vin;
        this.dateTime = dateTime;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getVin() {
        return vin;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Object[] getRowData() {
        return new Object[] {dateTime, vin};
    }

}