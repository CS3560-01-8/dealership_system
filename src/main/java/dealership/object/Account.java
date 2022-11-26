package dealership.object;

import dealership.access.AccountDB;

public abstract class Account{

    private final String email;
    private final String firstName;
    private final String lastName;
    private final String phoneNum;

    public Account(String email, String firstName, String lastName, String phoneNum) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    //Returns null if account login failed
    public static Account getAccount(String email, String password) {
        return AccountDB.getAccount(email, password);
    }

    public static boolean exists(String email) {
        return AccountDB.accountRecordExists(email);
    }

    /*public void setEmail(String email) {
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
    }*/
}