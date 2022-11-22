package dealership.object;

import dealership.access.VehicleDB;

import java.util.ArrayList;

public class Vehicle {

    private final String vin;
    private final String make;
    private final String model;
    private final int year;
    private final String condition;
    private final int mileage;
    private final int listingPrice;
    private boolean sold;

    public Vehicle(String vin, String make, String model, int year, String condition, int mileage, int listingPrice, boolean sold) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.mileage = mileage;
        this.listingPrice = listingPrice;
        this.sold = sold;
    }

    public static ArrayList<Vehicle> getAvailableVehicles() {
        return VehicleDB.getAvailableVehicles();
    }

    //will return element for displaying in gui
    public Object[] getRowData() {
        return new Object[] {year, make, model, mileage, condition, "$" + listingPrice};
    }

    public void sell() {
        sold = true;
    }

}