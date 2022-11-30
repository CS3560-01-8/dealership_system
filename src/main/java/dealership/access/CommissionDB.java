package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Commission;

import java.util.ArrayList;

public class CommissionDB {

    public static void writeCommissions(ArrayList<Commission> commissions)
    {
        for (int i = 0; i < commissions.size(); i++)
        {
            DatabaseConnector.executeInsert(String.format(
                    "INSERT INTO `dealership`.`commission` (`employee_email`, `sale_id`, `percentage`) VALUES ('%s', '%d', '%d')",
                    commissions.get(i).getEmployee_email(), commissions.get(i).getSale_id(), commissions.get(i).getPercentage()
            ));
        }
    }
}
