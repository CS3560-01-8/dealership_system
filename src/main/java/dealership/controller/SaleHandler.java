package dealership.controller;

import dealership.access.AppointmentDB;
import dealership.access.SaleDB;
import dealership.access.VehicleDB;
import dealership.object.Sale;

public class SaleHandler {

    public static boolean makeSale(int saleID, float agreedPrice, float tax, String cardNum, String vin){
        if(!VehicleDB.checkVin(vin)) return false;
        SaleDB.writeSale(new Sale(saleID, agreedPrice, tax, cardNum, vin));
        return true;
    }
}
