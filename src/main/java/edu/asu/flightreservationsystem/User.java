package edu.asu.flightreservationsystem;


import java.io.Serializable;
import java.util.ArrayList;

public class User extends ApplicationUser implements FlightSearchInterface, BookingProcess, Serializable {

    private ArrayList<Booking> Bookings = new ArrayList<>();

//    public User(ApplicationUser user){
//        this.setFirstName(user.getFirstName());
//        this.setLastName(user.getLastName());
//        this.setPassword(user.getPassword());
//        this.setEmailAddress(user.getEmailAddress());
//        this.setFirstName(user.getFirstName());
//        this.setUser(true);
//    }
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
