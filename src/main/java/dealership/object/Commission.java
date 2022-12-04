package dealership.object;

import java.util.HashMap;

public class Commission {

    private int percentage;

    private String employeeEmail;

    private String vin;

    public static final HashMap<String, Integer> weightMap = new HashMap<String, Integer>(){
            {
                put("Sr Salesperson", 4);
                put("Jr Salesperson", 2);
                put("Manager", 1);
            }
    };

    public Commission(String employeeEmail, String vin, int percentage) {
        this.percentage = percentage;
        this.employeeEmail = employeeEmail;
        this.vin = vin;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getVin() {
        return vin;
    }

    public String getEmployee_email() {
        return employeeEmail;
    }
}