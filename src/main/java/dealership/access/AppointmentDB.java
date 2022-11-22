package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentDB {

    public static void write(Appointment app){
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`appointment` (`customer_email`, `vin`, `date_time`) VALUES ('%s', '%s', '%s')",
                app.getCustomerEmail(), app.getVin(),app.getDateTime()));
    }

    public static boolean checkVin(String vin) {
        String query = "SELECT 1 FROM vehicle WHERE vin = '" + vin + "'";
        try {
            ResultSet res = DatabaseConnector.executeQuery(query);
            if (res.next()) {
                System.out.println("car found!");
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkAvailability(String dateTime){
        return false;
    }

    public static void getTime(){
        String query = "SELECT * FROM appointment";
       try{
           ResultSet res = DatabaseConnector.executeQuery(query);
           if (res.next()) {
               System.out.print(res.getDate("date_time"));
               System.out.print(" ");
               System.out.println(res.getTime("date_time"));
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
    }
}
