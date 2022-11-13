package dealership.object;

class Vehicle {

    private final String vin;
    private final String make;
    private final String model;
    private int year;
    private String condition;
    private int mileage;
    private int listingPrice;
    private String status;

    Vehicle(String vin, String make, String model, int year, String condition, int mileage, int listingPrice, String status) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.mileage = mileage;
        this.listingPrice = listingPrice;
        this.status = status;
    }

    //will return element for displaying in gui
    void getDisplayElement() {

    }

    void sell() {
        status = "sold";
    }

}