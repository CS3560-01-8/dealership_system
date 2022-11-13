package dealership.object;

abstract class Account{

    private String email;
    private String password;
    private String name;
    private String phoneNum;

    public Account(String email, String password, String name, String phoneNum) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}