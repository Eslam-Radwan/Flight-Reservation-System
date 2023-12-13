package edu.asu.mainPackage;

import java.io.Serializable;

public abstract class ApplicationUser implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String password;
    private boolean isUser; // true for users, false for admins

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUser() {
        return isUser;
    }

    @Override
    public boolean equals(Object obj) {
        ApplicationUser appUser = (ApplicationUser)obj;
        if(this.username.equals(appUser.getUsername()) && this.password.equals(appUser.getPassword())){
            return true;
        }
        else{
            return false;
        }

    }
}

