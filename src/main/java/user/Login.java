package user;

import db.Select;
import exceptions.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private final String email;
    private final String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
        if (!getEmailValidation()) {
            throw new InvalidEmailException();
        }
    }

    User authenticate() {
        User user = Select.selectFromAuthentication(email, password);
        if(user!=null){
            user.setAuthenticated(true);
            return user;
        }
        return null;
    }

    private boolean getEmailValidation() {
        Pattern emailValidation = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = emailValidation.matcher(email);
        return matcher.matches();
    }
}
