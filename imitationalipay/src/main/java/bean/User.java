package bean;

public class User {
    private String user;
    private String pass;
    private String email;

    public User(String nameString, String password, String emailString) {
        this.user = nameString;
        this.pass = password;
        this.email=emailString;
    }

    public String getGenerate() {
        return generate;
    }

    public User() {

    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public void setGenerate(String generate) {
        this.generate = generate;
    }

    private String generate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
