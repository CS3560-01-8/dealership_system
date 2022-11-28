package dealership.controller;

import dealership.access.AccountDB;
import dealership.object.Account;
import dealership.object.Customer;
import dealership.object.Employee;

public class AccountHandler {

    // logged in account
    private static Account loggedInAccount;

    // create and save customer account to database
    public static boolean createCustomerAccount(String email, String password, String firstName, String lastName, String phoneNum, String address) {
        if (Customer.exists(email)) {
            return false;
        }
        //TODO fix direct call to DB with Customer object?
        AccountDB.writeCustomer(new Customer(email, firstName, lastName, phoneNum, address), password);
        return true;
    }
    
    // test if login is valid; true if so, false otherwise
    public static boolean tryLogin(String email, String password) {
        loggedInAccount = Account.getAccount(email, password);
        return loggedInAccount != null;
    }

    // test if user is logged into an account; true if so, false otherwise
    public static boolean isLoggedIn() {
        return loggedInAccount != null;
    }

    // get name of logged in user
    public static String getLoggedInName() {
        return loggedInAccount.getName();
    }

    // get email of logged in user
    public static String getLoggedInEmail() { return loggedInAccount.getEmail(); }

    // test if account is for an employee
    public static boolean isEmployee()
    {
        return (loggedInAccount instanceof Employee);
    }

}