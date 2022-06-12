package model;

public class Account {
    private String accountName;
    private String passWord;
    private String userName;
    private String age;
    private String numberPhone;
    private String address;
    private String email;
    private String role;

    public Account() {
    }

    public Account(String accountName, String passWord, String useName, String age, String numberPhone, String address, String email, String role) {
        this.accountName = accountName;
        this.passWord = passWord;
        this.userName = useName;
        this.age = age;
        this.numberPhone = numberPhone;
        this.address = address;
        this.email = email;
        this.role = role;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", useName='" + userName + '\'' +
                ", age=" + age +
                ", numberPhone='" + numberPhone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String write() {
        return accountName + "," + passWord + "," + userName + "," +
                age + "," + numberPhone + "," + address + "," + email + "," + role;
    }
}
