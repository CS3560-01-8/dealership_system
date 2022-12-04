package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Commission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommissionDB {

    public static void writeCommissions(ArrayList<Commission> commissions)
    {
        for (int i = 0; i < commissions.size(); i++)
        {
            DatabaseConnector.executeInsert(String.format(
                    "INSERT INTO `dealership`.`commission` (`employee_email`, `vin`, `percentage`) VALUES ('%s', '%s', '%d')",
                    commissions.get(i).getEmployee_email(), commissions.get(i).getVin(),commissions.get(i).getPercentage()
            ));
        }
    }

    public static ArrayList<Commission> getCommissionsByVin(String vin){
        ArrayList<Commission> commissions = new ArrayList<>();
        try{
            ResultSet res = DatabaseConnector.executeQuery("SELECT * FROM dealership.commission WHERE vin = '" + vin + "';");
            while(res.next()){
                commissions.add(new Commission(res.getString("employee_email"), vin, res.getInt("percentage")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return commissions;
    }
}
