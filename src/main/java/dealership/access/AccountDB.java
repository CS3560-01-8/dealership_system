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
        return DatabaseConnector.tableContainsRow("customer", "customer_email", email);
    }

    public static boolean checkPass(String email, String password){
        String query = "SELECT 1 FROM account WHERE email = '" + email + "' AND password = '" + password + "'";
        try {
            ResultSet res = DatabaseConnector.executeQuery(query);
            if (res.next()) {
                System.out.println("account authenticated!");
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
