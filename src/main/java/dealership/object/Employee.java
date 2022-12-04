package dealership.object;

import dealership.access.SaleDB;

import java.util.ArrayList;

public class Employee extends Account {

    private final String role;
    private final ArrayList<Sale> sales;

    public Employee(String email, String firstName, String lastName, String phoneNum, String role, ArrayList<Sale> sales) {
        super(email, firstName, lastName, phoneNum);
        this.role = role;
        this.sales = sales;
    }

    public String getRole() {
        return role;
    }

    public void addSale(Sale pendingSale) {
        sales.add(pendingSale);
        SaleDB.writeSale(pendingSale);
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }
}