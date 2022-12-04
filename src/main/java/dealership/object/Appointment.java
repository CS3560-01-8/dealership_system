package dealership.object;


import dealership.access.VehicleDB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Appointment {

    private final String customerEmail;
    private final String vin;
    private final LocalDateTime dateTime;

    private final Vehicle vehicle;

    public Appointment(String customerEmail, String vin, LocalDateTime dateTime) {
        this.customerEmail = customerEmail;
        this.vin = vin;
        this.dateTime = dateTime;
        vehicle = VehicleDB.getVehicleByVin(vin);
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getVin() {
        return vin;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Object[] getRowData() {
        String date  = dateTime.format(DateTimeFormatter.ofPattern("EEEE, MMM d", Locale.ENGLISH));
        String time = dateTime.format(DateTimeFormatter.ofPattern("hh:ss a", Locale.ENGLISH))
                + dateTime.plusHours(1).format(DateTimeFormatter.ofPattern(" - hh:ss a", Locale.ENGLISH));
        return new Object[] {date, time, vehicle.toString()};
    }

}