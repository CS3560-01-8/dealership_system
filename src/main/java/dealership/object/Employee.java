package dealership.object;

public class Employee extends Account {
    private String role;

    public Employee(String email, String firstName, String lastName, String phoneNum, String role) {
        super(email, firstName, lastName, phoneNum);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}