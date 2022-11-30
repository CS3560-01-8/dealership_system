package dealership.object;

public class Commission {

	private int percentage;

	private String employeeEmail;

	private int saleId;

	public Commission(String employeeEmail, int saleId, int percentage)
	{

		this.percentage = percentage;
		this.employeeEmail = employeeEmail;
		this.saleId = saleId;
	}

	public int getPercentage() {
		return percentage;
	}

	public int getSale_id() {
		return saleId;
	}

	public String getEmployee_email() {
		return employeeEmail;
	}
}