package edu.asu.flightreservationsystem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;

public class Booking implements Serializable {
    private int bookingID;
    private int numberOfPassengers;
    private int flightClass;
    private String bookingStatus;
    private ArrayList<Ticket> Tickets;
    private Flight flight;
    private Payment payment;


    public Booking(){
        Tickets = new ArrayList<>();
    }
    public Booking(int bookingID, Flight flight, int numberOfPassengers, int flightClass) {
        Tickets = new ArrayList<>();
        this.bookingID = bookingID;
        this.bookingStatus = "pending payment";
        this.flight = flight;
        this.flightClass=flightClass;
        this.numberOfPassengers=numberOfPassengers;
    }

    //Getters
    public int getBookingID() {
        return bookingID;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public ArrayList<Ticket> getTicketinfo() {
        return Tickets;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getFlightClass() {
        return flightClass;
    }

    //setters
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setFlightClass(int flightClass) {
        this.flightClass = flightClass;
    }

    public void setTicketseat(int index, Seat seat){
        Ticket ticket=this.Tickets.get(index);
        ticket.setPassengerSeat(seat);
        this.Tickets.set(index, ticket);
    }
    //adding
    public void addTicket(Ticket ticket){
        this.Tickets.add(ticket);
    }
}