package user;

import db.Insert;
import notes.Note;

import java.util.ArrayList;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private boolean isAuthenticated = false;
    private final ArrayList<Note> notes = new ArrayList<Note>();

    public User(String name, String email, String password) {

        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public boolean addNote(String title, String name) {
        if (isAuthenticated) {
            Note note = Insert.addNotesToTable(title, name, email);
            if (note != null) {
                notes.add(note);
                return true;
            }
        }
        return false;
    }

}