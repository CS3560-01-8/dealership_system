package dealership.object;

import dealership.access.VehicleDB;
import dealership.util.VehicleFilter;

import java.util.ArrayList;

public class Vehicle {

    private final String vin;
    private final String make;
    private final String model;
    private final int year;
    private final String style;
    private final String color;
    private final int mileage;
    private final int listingPrice;
    private boolean sold;

    public Vehicle(String vin, String make, String model, int year, String style, String color, int mileage, int listingPrice, boolean sold) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.style = style;
        this.color = color;
        this.mileage = mileage;
        this.listingPrice = listingPrice;
        this.sold = sold;
    }

    public static ArrayList<Vehicle> getAvailableVehicles(VehicleFilter filter) {
        return VehicleDB.getAvailableVehicles(filter.toWhereClause());
    }

    public String getVin() {
        return vin;
    }

    //for loading into jTable
    public Object[] getRowData() {
        return new Object[] {year, make, model, style, color, mileage, "$" + listingPrice};
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }

    public void sell() {
        sold = true;
    }

}