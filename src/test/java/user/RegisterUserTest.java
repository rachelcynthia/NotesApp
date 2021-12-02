package user;

import db.Insert;
import db.JDBC;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.PasswordDoesNotMatchException;
import org.junit.jupiter.api.Test;
import util.Helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegisterUserTest {

    @Test
    void shouldBeAbleToCreateANewUserWithValidFields() {

        String name = "Test user";
        String email = "user12@gmail.com";
        String password = "Password@123";

        RegisterUser newUser = new RegisterUser(name, email, password, password);

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
        RegisterUser newUser = new RegisterUser(name, email, password, password);

        assertThrows(InvalidNameException.class, newUser::create);
    }

    @Test
    void shouldThrowInvalidEmailExceptionWhenEmailIsNotValid() {
        String name = "User";
        String email = "email@j";
        String password = "Password@123";
        RegisterUser newUser = new RegisterUser(name, email, password, password);

        assertThrows(InvalidEmailException.class, newUser::create);
    }

    @Test
    void shouldThrowInvalidPasswordExceptionWhenPasswordIsNotValid() {
        String name = "User";
        String email = "user@gmail.com";
        String password = "password";
        RegisterUser newUser = new RegisterUser(name, email, password, password);

        assertThrows(InvalidPasswordException.class, newUser::create);
    }

    @Test
    void shouldThrowPasswordDoesNotMatchExceptionWhenPasswordDoesNotMatch() {
        String name = "User";
        String email = "user@gmail.com";
        String password = "Password@123";
        String confirmPassword = "confirmPassword";
        RegisterUser newUser = new RegisterUser(name, email, password, confirmPassword);

        assertThrows(PasswordDoesNotMatchException.class, newUser::create);
    }
}