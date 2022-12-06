package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Account;
import dealership.object.Customer;
import dealership.object.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDB {

    public static void writeCustomer(Customer account, String password) {
        DatabaseConnector.executeUpdate(String.format(
                "INSERT INTO `dealership`.`account` (`email`, `first_name`, `last_name`, `phone_num`, `password`) VALUES ('%s', '%s', '%s', '%s', '%s')",
                account.getEmail(), account.getFirstName(), account.getLastName(), account.getPhoneNum(), password));
        DatabaseConnector.executeUpdate(String.format(
                "INSERT INTO `dealership`.`customer` (`customer_email`, `address`) VALUES ('%s', '%s')",
                account.getEmail(), account.getAddress()));
    }

    public static boolean accountRecordExists(String email) {
        return DatabaseConnector.tableContainsRow("account", "email", email);
    }

    public static boolean accountRecordExists(String email, String password) {
        try {
            ResultSet res = DatabaseConnector.executeQuery(String.format(
                    "SELECT 1 FROM account WHERE email = '%s' AND password = '%s'", email, password));
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean customerRecordExists(String email) {
        return DatabaseConnector.tableContainsRow("customer", "customer_email", email);
    }

    public static Account getAccount(String email, String password) {
        Account account = null;
        if (accountRecordExists(email, password)) {
            account = getCustomerWithAppointments(email);
            if (account == null) {
                account = getEmployee(email);
            }
        }
        return account;
    }

    public static Customer getCustomerWithAppointments(String email) {
        return getCustomer(email, true);
    }

    public static Customer getCustomerWithoutAppointments(String email) {
        return getCustomer(email, false);
    }

    private static Customer getCustomer(String email, boolean withAppointments) {
        try {
            ResultSet res = DatabaseConnector.executeQuery(String.format("SELECT account.email, account.first_name, account.last_name, " +
                    "account.phone_num, customer.address FROM account JOIN customer ON customer.customer_email = account.email " +
                    "WHERE account.email = '%s';", email));
            if (res.next()) {
                return new Customer(res.getString("email"), res.getString("first_name"),
                        res.getString("last_name"), res.getString("phone_num"),
                        res.getString("address"),
                        withAppointments ? AppointmentDB.getAppointments(email) : new ArrayList<>());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Employee getEmployee(String email) {
        try {
            ResultSet res = DatabaseConnector.executeQuery(String.format("SELECT account.email, account.first_name, account.last_name, " +
                    "account.phone_num, employee.role FROM account JOIN employee ON employee.employee_email = account.email " +
                    "WHERE account.email = '%s';", email));
            if (res.next()) {
                return new Employee(res.getString("email"), res.getString("first_name"),
                        res.getString("last_name"), res.getString("phone_num"),
                        res.getString("role"), SaleDB.getSales(email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Employee> getAllEmployeesBesides(String email){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            ResultSet res = DatabaseConnector.executeQuery(String.format("SELECT account.email, account.first_name, account.last_name, " +
                    "account.phone_num, employee.role FROM account JOIN employee ON employee.employee_email = account.email WHERE employee.employee_email != '%s';",
                    email));
            while (res.next()) {
                employees.add(new Employee(res.getString("email"), res.getString("first_name"),
                        res.getString("last_name"), res.getString("phone_num"), res.getString("role"), new ArrayList<>()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
