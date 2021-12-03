package user;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.PasswordDoesNotMatchException;
import org.junit.jupiter.api.Test;
import util.Helpers;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @Test
    void shouldBeAbleToCreateANewUserWithValidFields() {

        String name = "Test user";
        String email = "user12@gmail.com";
        String password = "Password@123";

        Register newUser = new Register(name, email, password, password);

        User user = newUser.create();
        if (user != null) {
            Helpers.deleteAfterTesting(email);
        }

        assertNotNull(user);
    }

    @Test
    void shouldThrowIllegalNameExceptionWhenNameIsNotValid() {
        String name = "User123";
        String email = "user@gmail.com";
        String password = "Password@123";
        Register newUser = new Register(name, email, password, password);

        assertThrows(InvalidNameException.class, newUser::create);
    }

    @Test
    void shouldThrowInvalidEmailExceptionWhenEmailIsNotValid() {
        String name = "User";
        String email = "email@j";
        String password = "Password@123";
        Register newUser = new Register(name, email, password, password);

        assertThrows(InvalidEmailException.class, newUser::create);
    }

    @Test
    void shouldThrowInvalidPasswordExceptionWhenPasswordIsNotValid() {
        String name = "User";
        String email = "user@gmail.com";
        String password = "password";
        Register newUser = new Register(name, email, password, password);

        assertThrows(InvalidPasswordException.class, newUser::create);
    }

    @Test
    void shouldThrowPasswordDoesNotMatchExceptionWhenPasswordDoesNotMatch() {
        String name = "User";
        String email = "user@gmail.com";
        String password = "Password@123";
        String confirmPassword = "confirmPassword";
        Register newUser = new Register(name, email, password, confirmPassword);

        assertThrows(PasswordDoesNotMatchException.class, newUser::create);
    }
}