package dealership.controller;

import dealership.access.AccountDB;
import dealership.object.Account;
import dealership.object.Customer;

public class AccountHandler {

    private static Account loggedInAccount;

    public static boolean createCustomerAccount(String email, String password, String firstName, String lastName, String phoneNum, String address) {
        if (Customer.exists(email)) {
            return false;
        }
        //TODO fix direct call to DB with Customer object?
        AccountDB.writeCustomer(new Customer(email, firstName, lastName, phoneNum, address), password);
        return true;
    }

    public static boolean tryLogin(String email, String password) {
        loggedInAccount = Account.getAccount(email, password);
        return loggedInAccount != null;
    }

    public static boolean isLoggedIn() {
        return loggedInAccount != null;
    }

}
