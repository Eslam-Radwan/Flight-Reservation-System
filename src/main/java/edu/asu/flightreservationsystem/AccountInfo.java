package edu.asu.flightreservationsystem;

import java.io.Serializable;

public class AccountInfo implements Serializable {
    private String username;
    private String password;
    private boolean isUser; //  1 for user, 0 for admin

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setUser(boolean user) {
        isUser = user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUser() {
        return isUser;
    }
}
