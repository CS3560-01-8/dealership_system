package dealership.object;

public class Sale {
    
    private int id;
    private double agreedPrice;
    private double tax;
    private String cardNumber;
    private String vin;

    public Sale(int id, double agreedPrice, double tax, String cardNumber, String vin) {
        this.id = id;
        this.agreedPrice = agreedPrice;
        this.tax = tax;
        this.cardNumber = cardNumber;
        this.vin = vin;
    }

    public int getId() {
        return id;
    }

    public double getAgreedPrice() {
        return agreedPrice;
    }

    public double getTax() {
        return tax;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getVin() {
        return vin;
    }
}
