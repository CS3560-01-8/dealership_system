package dealership.object;

import java.util.ArrayList;

public class Employee extends Account {
    private String role;
    private ArrayList<Sale> sales;

    public Employee(String email, String firstName, String lastName, String phoneNum, String role, ArrayList<Sale> sales) {
        super(email, firstName, lastName, phoneNum);
        this.role = role;
        this.sales = sales;
    }

    public String getRole() {
        return role;
    }

}