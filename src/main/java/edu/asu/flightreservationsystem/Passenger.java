package com.example.flightsearch;


import java.io.Serializable;

public class Passenger implements Serializable {
    private String firstName;
    private String lastName;
    private int ID;
    private Ticket ticketInfo;
    private  Booking bookingInfo;

    public Passenger(String firstName, String lastName, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public Ticket getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(Ticket ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public Booking getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(Booking bookingInfo) {
        this.bookingInfo = bookingInfo;
    }


}