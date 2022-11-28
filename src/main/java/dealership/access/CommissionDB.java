package dealership.access;

import dealership.db.DatabaseConnector;
import dealership.object.Commission;

public class CommissionDB {

    public static void writeCommission(Commission commission)
    {
        DatabaseConnector.executeInsert(String.format(
                "INSERT INTO dealership.commission (employee_email, sale_id, percentage) VALUES ('%s', '%d', '%d')",
                commission.getEmployee_email(), commission.getSale_id(), commission.getPercentage()
        ));
    }
}
