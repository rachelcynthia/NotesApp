package user;

import exceptions.IllegalNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {

    @Test
    void shouldBeAbleToCreateANewUserWithValidFields() {
        String name = "Test User";
        String email = "user@gmail.com";
        String password = "password";
        RegisterUser newUser = new RegisterUser(name, email, password, password);

        User user = newUser.create();

        assertNotNull(user);
    }

    @Test
    void shouldThrowIllegalNameExceptionWhenNameIsNotValid() {
        String name = "User123";
        String email = "user@gmail.com";
        String password = "password";
        RegisterUser newUser = new RegisterUser(name, email, password, password);

        assertThrows(IllegalNameException.class, newUser::create);
    }
}