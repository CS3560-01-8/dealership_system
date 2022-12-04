package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppointmentDB {

    public static void writeAppointment(Appointment appointment) {
        String query = "INSERT INTO `dealership`.`appointment` (`customer_email`, `vin`, `date_time`) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = DatabaseConnector.getConnection().prepareStatement(query);
            ps.setString(1, appointment.getCustomerEmail());
            ps.setString(2, appointment.getVin());
            ps.setObject(3, appointment.getDateTime());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAppointmentValid(String customerEmail, String vin, LocalDateTime dateTime) {
        String query = "SELECT 1 FROM appointment WHERE date_time = ? AND (vin = ? OR customer_email = ?)";
        try {
            PreparedStatement ps = DatabaseConnector.getConnection().prepareStatement(query);
            ps.setObject(1, dateTime);
            ps.setString(2, vin);
            ps.setString(3, customerEmail);
            return !ps.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Appointment> getAppointments(String email) {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM appointment WHERE customer_email = '" + email + "' ORDER BY date_time");
            while (res.next()) {
                appointments.add(new Appointment(res.getString(1), res.getString(2), res.getObject(3, LocalDateTime.class)));
                System.out.print(String.format("%s, %s, %s\n", res.getString(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public static void deleteAppointment(String customerEmail, String vin) {
        DatabaseConnector.executeUpdate("DELETE FROM dealership.appointment WHERE customer_email = '" + customerEmail + "' AND vin = '" + vin + "'");
    }
}