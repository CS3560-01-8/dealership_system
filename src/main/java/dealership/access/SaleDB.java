package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Sale;
import dealership.object.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
            ResultSet res = DatabaseConnector.executeQuery("SELECT sale.*, vehicle.year, vehicle.make, vehicle.model, vehicle.style, " +
                    "vehicle.color, vehicle.mileage, vehicle.listing_price FROM sale " +
                    "JOIN commission ON sale.vin = commission.vin " +
                    "JOIN vehicle ON sale.vin = vehicle.vin " +
                    "WHERE commission.employee_email = '" + email + "' ORDER BY date");

            while (res.next()) {
                sales.add(new Sale(CommissionDB.getCommissionsByVin(res.getString("vin")),
                        res.getObject("date", LocalDateTime.class),
                        new Vehicle(res.getString("vin"), res.getString("make"),
                                res.getString("model"), res.getInt("year"),
                                res.getString("style"), res.getString("color"),
                                res.getInt("mileage"), res.getInt("listing_price"), true),
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