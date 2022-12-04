package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDB {
    public static void writeSale(Sale sale) {

        String query = "INSERT INTO `dealership`.`sale` (`vin`, `agreed_price`, `tax`, `card_num`, `date`, `customer_email`) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = DatabaseConnector.getConnection().prepareStatement(query);
            ps.setString(1, sale.getVehicle().getVin());
            ps.setFloat(2, sale.getAgreedPrice());
            ps.setFloat(3, sale.getTax());
            ps.setString(4, sale.getCardNumber());
            ps.setObject(5, sale.getDate());
            ps.setString(6, sale.getCustomer().getEmail());
            ps.execute();

            CommissionDB.writeCommissions(sale.getCommission());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Sale> getSales(String email) {
        ArrayList<Sale> sales = new ArrayList<>();
        try {
            ResultSet res = DatabaseConnector.executeQuery("SELECT sale.vin, sale.agreed_price, sale.tax, sale.date, " +
                    "sale.customer_email, sale.card_num FROM sale JOIN commission ON sale.vin = commission.vin " +
                    "WHERE commission.employee_email = '" + email + "' ORDER BY date");

            while (res.next()) {
                //TODO join with vehicle table so we don't make another query for each sale
                sales.add(new Sale(CommissionDB.getCommissionsByVin(res.getString("vin")),
                        VehicleDB.getVehicleByVin(res.getString("vin")),
                        res.getFloat("agreed_price"),
                        res.getFloat("tax"),
                        res.getString("card_num"),
                        AccountDB.getCustomerWithoutAppointments(res.getString("customer_email"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

}