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

    public Payment getPayment() {
        return payment;
    }
    public  String getClassString(){
        if(this.flightClass==0){
            return "Economy";
        }
        else if(this.flightClass==1){
            return "Business";
        }
        else{
            return "First class";
        }
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

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    //adding
    public void addTicket(Ticket ticket){
        this.Tickets.add(ticket);
    }



    public void putSeatsInFlight(){
        if(flightClass==0) {
            for (int i = 0; i < numberOfPassengers; i++) {
                flight.setEconomySeats(Tickets.get(i).getPassengerSeat().getSeatRow(), Tickets.get(i).getPassengerSeat().getSeatColumn(), Tickets.get(i).getPassengerSeat());
            }
        }
        if(flightClass==1) {
            for (int i = 0; i < numberOfPassengers; i++) {
                flight.setBuisinesseats(Tickets.get(i).getPassengerSeat().getSeatRow(), Tickets.get(i).getPassengerSeat().getSeatColumn(), Tickets.get(i).getPassengerSeat());
            }
        }
        if(flightClass==2) {
            for (int i = 0; i < numberOfPassengers; i++) {
                flight.setFirstClassSeats(Tickets.get(i).getPassengerSeat().getSeatRow(), Tickets.get(i).getPassengerSeat().getSeatColumn(), Tickets.get(i).getPassengerSeat());
            }
        }
    }


}