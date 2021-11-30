package user;

public class RegisterUser {

    private final String name;
    private final String email;
    private final String password;
    private final String confirmPassword;

    public RegisterUser(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public User create() {
        return new User(name, email, password);
    }
}