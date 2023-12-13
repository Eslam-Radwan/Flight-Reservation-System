package edu.asu.flightreservationsystem;

import java.util.Scanner;

public interface BookingProcess extends PaymentProcess, SeatSelection{
    default Booking bookingProcess(Booking booking) {
        Scanner input = new Scanner(System.in);
        System.out.println("===============welcome to booking===============");
        Flight flight = booking.getFlight();
        double ticketFare = flight.getSeatPrice(booking.getFlightClass());


        for (int i = 0; i < booking.getNumberOfPassengers(); i++) {
            System.out.printf("please Enter passenger %d first name:", i + 1);
            String firstName = input.next();
            System.out.printf("please Enter passenger %d last name:", i + 1);
            String lastName = input.next();
            System.out.printf("please Enter passenger %d ID:", i + 1);
            int id = input.nextInt();
            Passenger passenger = new Passenger(firstName, lastName, id);
            Ticket ticket = new Ticket(passenger, ticketFare);

            booking.addTicket(ticket);

        }

        seatSelection(booking);
        return paymentProcess(booking);
    }
}
