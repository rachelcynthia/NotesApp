package user;

import notes.Note;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    private boolean isAuthenticated = false;
    private ArrayList<Note> notes = new ArrayList<Note>();

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

    public boolean addNote(Note note){
        if(isAuthenticated){
            notes.add(note);
            return true;
        }
        return false;
    }

}