package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Sale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDB {
    public static void writeSale(Sale sale){
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`sale` (`sale_id`, `agreed_price`, `tax`, 'card_num', 'vin') VALUES ('%d', '%f', '%f', '%s', '%s')",
                sale.getId(), sale.getAgreedPrice(), sale.getTax(), sale.getCardNumber(), sale.getVin()));
    }

    public static ArrayList<Sale>  getSale()
    {
        ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM sale");
        ArrayList<Sale> sales = new ArrayList<>();
        try {
            while (res.next()) {
                sales.add(new Sale(res.getInt(1), res.getFloat(2), res.getFloat(3), res.getString(4),
                        res.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }



}