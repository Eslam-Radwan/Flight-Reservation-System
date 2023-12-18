package edu.asu.flightreservationsystem;


import java.io.Serializable;
import java.util.ArrayList;

public class User extends ApplicationUser implements Serializable {

    private ArrayList<Booking> Bookings = new ArrayList<>();

    public void setBookings(Booking booking) {
        Bookings.add(booking);
    }

    public ArrayList<Booking> getBookings() {
        return Bookings;
    }

    @Override
    public String toString() {
        return "First Name: " + this.getFirstName() + " Last Name: " + this.getLastName() +
                " Username: " + this.getUsername() + " Email Address: " + this.getEmailAddress();
    }
}
