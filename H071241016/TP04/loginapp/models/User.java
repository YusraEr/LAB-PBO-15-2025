package loginapp.models;

public class User {
    private String username;
    private String password;

    public User() {
        this.username = "";
        this.password = "";
    }

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter (opsional, jika butuh)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

