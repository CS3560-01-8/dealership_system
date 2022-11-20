package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Customer;

public class AccountDB {

    public static void write(Customer account) {
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`account` (`email`, `first_name`, `last_name`, `phone_num`, `password`) VALUES ('%s', '%s', '%s', '%s', '%s')",
                account.getEmail(), account.getFirstName(), account.getLastName(), account.getPhoneNum(), account.getPassword()));
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`customer` (`customer_email`, `address`) VALUES ('%s', '%s')",
                account.getEmail(), account.getAddress()));
    }

}
