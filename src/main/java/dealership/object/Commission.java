package dealership.object;

public class Commission {

    private int percentage;

    private String employeeEmail;

    private String vin;

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