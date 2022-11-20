package dealership.controller;

import dealership.object.Customer;

public class AccountHandler {

    public static boolean createCustomerAccount(String email, String password, String firstName, String lastName, String phoneNum, String address) {
        if (Customer.exists(email)) {
            return false;
        }
        new Customer(email, password, firstName, lastName, phoneNum, address);
        return true;
    }

}
