package dealership.object;

import dealership.access.AppointmentDB;

public class Appointment {
    private String customerEmail;
    private String vin;
    private String dateTime;

    public Appointment(String customerEmail, String vin, String dateTime) {
        this.customerEmail = customerEmail;
        this.vin = vin;
        this.dateTime = dateTime;
        //AppointmentDB.write(this);
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

    public static boolean vinExist(String vin) {
        return AppointmentDB.checkVin(vin);
    }
}