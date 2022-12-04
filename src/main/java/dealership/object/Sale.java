package dealership.object;

import java.time.LocalDateTime;
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
        for (int i = 0; i < allSaleEmployees.size(); i++)
        {
            this.commissions.add(new Commission(allSaleEmployees.get(i).getEmail(), vehicle.getVin(), 10));
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

    public void addCommission(Commission commission) {
        commissions.add(commission);
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
}