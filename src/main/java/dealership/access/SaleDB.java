package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Sale;

public class SaleDB {
    public static void writeSale(Sale sale){
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO `dealership`.`sale` (`sale_id`, `agreed_price`, `tax`, 'card_num', 'vin') VALUES ('%d', '%f', '%f', '%s', '%s')",
                sale.getId(), sale.getAgreedPrice(), sale.getTax(), sale.getCardNumber(), sale.getVin()));
    }
}
