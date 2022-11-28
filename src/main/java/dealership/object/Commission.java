package dealership.object;

public class Commission {

	private int percentage;

	private String employee_email;

	private int sale_id;

	public Commission(int percentage, String employee_email, int sale_id)
	{
		this.percentage = percentage;
		this.employee_email = employee_email;
		this.sale_id = sale_id;
	}

	public int getPercentage() {
		return percentage;
	}

	public int getSale_id() {
		return sale_id;
	}

	public String getEmployee_email() {
		return employee_email;
	}
}