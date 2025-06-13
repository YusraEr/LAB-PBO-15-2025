package login_app.models;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isPasswordCorrect(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
