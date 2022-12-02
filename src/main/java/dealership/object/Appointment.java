package dealership.object;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private final String customerEmail;
    private final String vin;
    private final LocalDateTime dt;

    public Appointment(String customerEmail, String vin, LocalDateTime dt) {
        this.customerEmail = customerEmail;
        this.vin = vin;
        this.dt = dt;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getVin() {
        return vin;
    }

    public LocalDateTime getDateTime() {
        return dt;
    }

    public Object[] getRowData() {
        return new Object[] {dt.format(DateTimeFormatter.ofPattern("EEEE, MMM d @ h a")), vin};
    }

}