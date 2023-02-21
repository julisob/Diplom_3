public class Credentials {
    public String email;
    public String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Credentials(User user) {
        this.email = user.email;
        this.password = user.password;
    }
}
