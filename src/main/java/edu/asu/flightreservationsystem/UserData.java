package edu.asu.flightreservationsystem;

public class UserData {
    private static final UserData instance = new UserData();
    private User user;

    public static UserData getInstance() {return instance;}

    public User getUserData() {return user;}

    public void setUserData(User UserData) {
        this.user = UserData;
    }
}
