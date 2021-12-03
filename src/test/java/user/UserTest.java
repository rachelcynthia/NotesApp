package user;

import notes.Note;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void shouldNotCreateNewNoteWhenUserIsNotAuthenticated() {
        User user = new User("User", "user@gmail.com", "Password@123");
        boolean isNoteAdded = user.addNote(new Note("sample title", "sample Note"));
        assertFalse(isNoteAdded);
    }

    @Test
    void shouldCreateNewNoteWhenUserIsAuthenticated() {
        User user = new User("User", "user@gmail.com", "Password@123");
        user.setAuthenticated(true);
        boolean isNoteAdded = user.addNote(new Note("sample title", "sample Note"));
        assertTrue(isNoteAdded);
    }
}