package user;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

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
        if(!getNameValidation()){
            throw new InvalidNameException();
        }

        if(!getEmailValidation()){
            throw new InvalidEmailException();
        }

        return new User(name, email, password);
    }

    private boolean getNameValidation() {
        Pattern nameValidation = Pattern.compile("^[A-Za-z][A-Za-z\\s]{2,63}$");
        Matcher matcher = nameValidation.matcher(name);
        return matcher.matches();
    }

    private boolean getEmailValidation() {
        Pattern nameValidation = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = nameValidation.matcher(email);
        return matcher.matches();
    }
}