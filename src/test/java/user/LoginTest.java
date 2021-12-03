package user;

import exceptions.InvalidEmailException;
import org.junit.jupiter.api.Test;
import util.Helpers;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    @Test
    void shouldThrowExceptionWhenEmailIsNotValid() {
        String email = "user";
        String password = "password";

        assertThrows(InvalidEmailException.class, () -> new Login(email, password));
    }

    @Test
    void shouldAuthenticateWhenCredentialsAreCorrect() {
        String name = "user";
        String email = "user@gmail.com";
        String password = "Password@123";

        Register register = new Register(name, email, password, password);
        register.create();

        Login loginUser = new Login(email, password);
        boolean isAuthenticated = loginUser.authenticate();
        Helpers.deleteAfterTesting(email);

        assertTrue(isAuthenticated);
    }

    @Test
    void shouldNotAuthenticateWhenCredentialsAreIncorrect() {
        String name = "user";
        String email = "user@gmail.com";
        String password = "Password@123";

        Register register = new Register(name, email, password, password);
        register.create();

        Login loginUser = new Login(email, "pass");
        boolean isAuthenticated = loginUser.authenticate();
        Helpers.deleteAfterTesting(email);

        assertFalse(isAuthenticated);
    }
}