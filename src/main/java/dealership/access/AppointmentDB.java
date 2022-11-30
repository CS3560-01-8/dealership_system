package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentDB {

    public static void writeAppointment(Appointment app) {
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`appointment` (`customer_email`, `vin`, `date_time`) VALUES ('%s', '%s', '%s')",
                app.getCustomerEmail(), app.getVin(), app.getDateTime()));
    }

    public static boolean checkAvailability(String customerEmail, String vin, String dateTime) {
        if (!VehicleDB.checkVin(vin)) return false;
        String query1 = "SELECT 1 FROM appointment WHERE date_time = '" + dateTime + "' AND vin = '" + vin + "'";
        String query2 = "SELECT 1 FROM appointment WHERE date_time = '" + dateTime + "' AND customer_email = '" + customerEmail + "'";
        try {
            ResultSet res = DatabaseConnector.executeQuery(query1);
            if (res.next()) {
                System.out.println("Time conflict!");
                return false;
            }
            res = DatabaseConnector.executeQuery(query2);
            if (res.next()) {
                System.out.println("Time conflict!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void getTime() {
        String query = "SELECT * FROM appointment";
        try {
            ResultSet res = DatabaseConnector.executeQuery(query);
            if (res.next()) {
                System.out.println(res.getDate("date_time") + " " + res.getTime("date_time"));
                //System.out.println(res.getTime("date_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Appointment> getAllAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM appointment");
            while (res.next()) {
                appointments.add(new Appointment(res.getString(1), res.getString(2), res.getString(3)));
                System.out.print(String.format("%s, %s, %s\n", res.getString(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public static ArrayList<Appointment> getAppointments(String email) {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM appointment WHERE customer_email = '" + email + "'");
            while (res.next()) {
                appointments.add(new Appointment(res.getString(1), res.getString(2), res.getString(3)));
                System.out.print(String.format("%s, %s, %s\n", res.getString(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public static void deleteAppointment(String customerEmail, String vin) {
        DatabaseConnector.executeInsert("DELETE FROM dealership.appointment WHERE customer_email = '" + customerEmail + "' AND vin = '" + vin + "'");
    }
}