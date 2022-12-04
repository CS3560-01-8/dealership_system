package dealership.object;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sale {

    private final float agreedPrice;
    private final float tax;
    private final String cardNumber;
    private final Vehicle vehicle;
    private final LocalDateTime date;
    private final ArrayList<Commission> commissions;
    private final Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public Sale(Vehicle vehicle, float agreedPrice, float tax, String cardNumber, Customer customer, ArrayList<Employee> allSaleEmployees) {
        this.agreedPrice = agreedPrice;
        this.tax = tax;
        this.cardNumber = cardNumber;
        this.vehicle = vehicle;
        this.date = LocalDateTime.now();
        this.commissions = new ArrayList<>();
        this.customer = customer;
        float totalWeights = 0;
        for (Employee employee : allSaleEmployees){
            totalWeights += Commission.weightMap.get(employee.getRole());
        }
        for (Employee employee : allSaleEmployees) {
            this.commissions.add(new Commission(employee.getEmail(), vehicle.getVin(), Math.round(Commission.weightMap.get(employee.getRole()) / totalWeights * 15)));
        }
    }

    public Sale(ArrayList<Commission> commissions, Vehicle vehicle, float agreedPrice, float tax, String cardNumber, Customer customer){
        this.agreedPrice = agreedPrice;
        this.tax = tax;
        this.cardNumber = cardNumber;
        this.vehicle = vehicle;
        this.date = LocalDateTime.now();
        this.customer = customer;
        this.commissions = commissions;
    }

    public float getAgreedPrice() {
        return agreedPrice;
    }

    public float getTax() {
        return tax;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ArrayList<Commission> getCommission() {
        return commissions;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Object[] getRowData(Employee employee) {
        Commission commission = commissions.stream().filter(c -> c.getEmployee_email().equals(employee.getEmail())).findFirst().get();
        return new Object[] {date.format(DateTimeFormatter.ISO_DATE),
                vehicle.toString(),
                customer.getName(),
                String.format("$%.2f", agreedPrice + tax),
                String.format("$%.2f (%d%%)", commission.getPercentage() / 100.0 * (agreedPrice + tax), commission.getPercentage())};
    }

}