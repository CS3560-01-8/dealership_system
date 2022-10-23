package src;

class Employee extends Account {
    private String role;

    public Employee(String email, String password, String name, String phoneNum, String role) {
        super(email, password, name, phoneNum);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}