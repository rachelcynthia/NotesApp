package user;

public class Logout {
    public Logout(User user) {
        user.setAuthenticated(false);
    }
}
