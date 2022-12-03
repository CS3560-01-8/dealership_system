package dealership.object;


import dealership.access.VehicleDB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Appointment {

    private final String customerEmail;
    private final String vin;
    private final LocalDateTime dt;

    private final Vehicle vehicle;

    public Appointment(String customerEmail, String vin, LocalDateTime dt) {
        this.customerEmail = customerEmail;
        this.vin = vin;
        this.dt = dt;
        vehicle = VehicleDB.getVehicleByVin(vin);
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
        String date  = dt.format(DateTimeFormatter.ofPattern("EEEE, MMM d", Locale.ENGLISH));
        String time = dt.format(DateTimeFormatter.ofPattern("hh:ss a", Locale.ENGLISH))
                + dt.plusHours(1).format(DateTimeFormatter.ofPattern(" - hh:ss a", Locale.ENGLISH));
        return new Object[] {date, time, vehicle.toString()};
    }

}