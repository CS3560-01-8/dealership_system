package dealership.object;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sale {

    private float agreedPrice;
    private float tax;
    private String cardNumber;
    private String vin;
    private final LocalDateTime date;
    private ArrayList<Commission> commissions;

    public Sale(String vin, float agreedPrice, float tax, String cardNumber) {
        this.agreedPrice = agreedPrice;
        this.tax = tax;
        this.cardNumber = cardNumber;
        this.vin = vin;
        date = LocalDateTime.now();
        commissions = new ArrayList<Commission>();
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

    public String getVin() {
        return vin;
    }

    public ArrayList<Commission> getCommission() {
        return commissions;
    }

    public LocalDateTime getDate() {
        return date;
    }
}