package vinnsla;

public class User {
    private int userId;
    private String email;
    private String phone;
    private String userName;
    private Boolean isAdmin;

    public User(int userId, String email, String phone, String userName, Boolean isAdmin){
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.isAdmin = isAdmin;

    }

    public int getuserId(){
        return userId;
    }

    public String getEmail(){
        return email;
    }

    public int getUserId() {
        return userId;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
