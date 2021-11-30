package user;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {

    @Test
    void shouldBeAbleToCreateANewUserWithValidFields() {
        String name = "Test user";
        String email = "user@gmail.com";
        String password = "Password@123";
        RegisterUser newUser = new RegisterUser(name, email, password, password);

        User user = newUser.create();

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
}