package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDB {

    public static void write(Customer account) {
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`account` (`email`, `first_name`, `last_name`, `phone_num`, `password`) VALUES ('%s', '%s', '%s', '%s', '%s')",
                account.getEmail(), account.getFirstName(), account.getLastName(), account.getPhoneNum(), account.getPassword()));
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`customer` (`customer_email`, `address`) VALUES ('%s', '%s')",
                account.getEmail(), account.getAddress()));
    }

    public static boolean checkEmail(String email) {
        String query = "SELECT customer_email FROM customer";
        ResultSet res = DatabaseConnector.executeQuery(query);
        try {
            while(res.next()){
                if(email.equals(res.getString("customer_email")))
                {
                    System.out.println("Email found!");
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
