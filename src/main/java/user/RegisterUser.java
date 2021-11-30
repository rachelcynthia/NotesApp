package user;

import exceptions.IllegalNameException;

import javax.naming.InvalidNameException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern nameValidation = Pattern.compile("^[A-Za-z][A-Za-z\\s]{2,63}$");
        Matcher matcher = nameValidation.matcher(name);

        if(!matcher.matches()){
            throw new IllegalNameException();
        }

        return new User(name, email, password);
    }
}