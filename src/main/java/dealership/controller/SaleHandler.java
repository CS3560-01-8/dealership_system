package dealership.controller;

import dealership.access.AppointmentDB;
import dealership.access.CommissionDB;
import dealership.access.SaleDB;
import dealership.access.VehicleDB;
import dealership.object.Commission;
import dealership.object.Sale;

public class SaleHandler {

    public static boolean makeSale(String vin, float agreedPrice, float tax, String cardNum){
        if(!VehicleDB.isVinValid(vin)) return false;
        SaleDB.writeSale(new Sale(vin, agreedPrice, tax, cardNum));
        return true;
    }
    public static boolean makeCommission(Sale sale)
    {
        if(!SaleDB.isSaleValid(sale.getVin()))
        {
            return false;
        }
        CommissionDB.writeCommissions(sale.getCommission());
        return true;
    }

}
