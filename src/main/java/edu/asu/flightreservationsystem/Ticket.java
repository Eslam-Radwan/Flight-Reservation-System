package edu.asu.flightreservationsystem;

import java.io.Serializable;

public class Ticket implements Serializable {
    private static int previousTicketNumber;
    private int ticketNumber;
    private double ticketFare;
    private Passenger passenger;
    private Seat passengerSeat;

    public Ticket(Passenger passenger, double ticketFare) {
        ticketNumber = previousTicketNumber + 1;
        previousTicketNumber++;
        this.passenger = passenger;
        this.ticketFare = ticketFare;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(double ticketFare) {
        this.ticketFare = ticketFare;
    }

    public Seat getPassengerSeat() {
        return passengerSeat;
    }

    public void setPassengerSeat(Seat passengerSeat) {
        this.passengerSeat = passengerSeat;
    }

    @Override
    public String toString() {
        return " Ticket:" + "\n" +
                " TicketNumber: " + ticketNumber + "\t" +
                "TicketFare: " + ticketFare + "\n" +
                " passenger: " + passenger.getFirstName() + " " + passenger.getLastName() + "\t" + "Passenger Id: " + passenger.getID() +
                ", Seat number: " + passengerSeat.getSeatNumber() +
                "\n Seat number: " + passengerSeat.getSeatNumber() + "\t" +
                " Class: " + passengerSeat.getClass()
                ;
    }
}
