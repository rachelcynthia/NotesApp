package user;

import db.Insert;
import org.junit.jupiter.api.Test;
import util.Helpers;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void shouldNotCreateNewNoteWhenUserIsNotAuthenticated() {
        User user = new User("User", "user@gmail.com", "Password@123");
        boolean isNoteAdded = user.addNote("sample title", "sample Note");
        assertFalse(isNoteAdded);
    }

    @Test
    void shouldCreateNewNoteWhenUserIsAuthenticated() {
        String name = "Test";
        String email = "user3@gmail.com";
        String password = "Password@123";

        User user = Insert.addUserToAuthentication(name, email, password);
        user.setAuthenticated(true);

        boolean isNoteAdded = user.addNote("sample title", "sample Note");

        assertTrue(isNoteAdded);

        Helpers.deleteAfterTesting(email);
    }
}