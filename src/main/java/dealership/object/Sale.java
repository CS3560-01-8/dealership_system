package dealership.object;

import java.util.ArrayList;

public class Sale {
    
    private int id;
    private float agreedPrice;
    private float tax;
    private String cardNumber;
    private String vin;
    private ArrayList<Commission> commissions;

    public Sale(int id, float agreedPrice, float tax, String cardNumber, String vin) {
        this.id = id;
        this.agreedPrice = agreedPrice;
        this.tax = tax;
        this.cardNumber = cardNumber;
        this.vin = vin;
        commissions = new ArrayList<Commission>();
    }

    public void addCommission(Commission commission)
    {
        commissions.add(commission);
    }

    public int getId() {
        return id;
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

    public ArrayList<Commission> getCommission(){return commissions;}
}