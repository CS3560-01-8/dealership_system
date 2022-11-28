package dealership.object;

public class Sale {
    
    private int id;
    private float agreedPrice;
    private float tax;
    private String cardNumber;
    private String vin;

    public Sale(int id, float agreedPrice, float tax, String cardNumber, String vin) {
        this.id = id;
        this.agreedPrice = agreedPrice;
        this.tax = tax;
        this.cardNumber = cardNumber;
        this.vin = vin;
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
}
