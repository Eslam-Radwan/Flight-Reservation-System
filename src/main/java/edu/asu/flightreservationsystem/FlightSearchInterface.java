package edu.asu.flightreservationsystem;

import java.time.LocalDate;
import java.util.Scanner;

import static edu.asu.flightreservationsystem.WorkFlow.Flights;

public interface FlightSearchInterface {
    default boolean flightSearch(Booking booking) {
        Flight Seleceted_Flight = new Flight();

        Scanner input = new Scanner(System.in);

        // Setting the Attributes that the user searched for
        System.out.print("Enter your Desired departure Airport: ");
        Seleceted_Flight.setDepartureAirport(input.next());

        System.out.print("Enter your Desired arrival Airport: ");
        Seleceted_Flight.setArrivalAirport(input.next());

        int year,month,day;
        System.out.print("Enter year: ");
        year = input.nextInt();
        System.out.print("month: ");
        month = input.nextInt();
        System.out.print("day: ");
        day = input.nextInt();

        LocalDate departureDate = LocalDate.of(year,month,day);
        Seleceted_Flight.setDepartureDate(departureDate);
        System.out.println("Enter your Desired Seat Class: ");
        System.out.println("Press 0 for Economic Class");
        System.out.println("Press 1 for Business Class");
        System.out.println("Press 2 for First Class");
        int SeatClass = input.nextInt();
        booking.setFlightClass(SeatClass);
        System.out.print("Enter your Desired number of seats: ");
        int NumberOfSeats = input.nextInt();
        booking.setNumberOfPassengers(NumberOfSeats);


        // searching the database for flights with the same attributes that the user selected
        for (Flight flights : Flights) {
            if (Seleceted_Flight.equals(flights) && flights.getNumberOfAvailableSeat(SeatClass) >= NumberOfSeats) {
                int Choice = 0;
                FlightSearchRepresentation(flights);
                System.out.println("----------------------------------------------------");
                System.out.println("Press 1 to select the current flight");
                System.out.println("Press 2 to show the next available flight");
                Choice = input.nextInt();
                while (Choice != 1 && Choice != 2) {
                    System.out.println("Invalid Choice!!");
                    System.out.println("Press 1 to select the current flight");
                    System.out.println("Press 2 to show the next available flight");
                    Choice = input.nextInt();
                }
                if (Choice == 1) {
                    Seleceted_Flight = flights;
                    booking.setFlight(Seleceted_Flight);
                    return true;

                }
            }
        }
        System.out.println("You haven't selected a flight!");
        return false;
    }

    private void FlightSearchRepresentation(Flight flight) {
        System.out.println("Flight Informations: ");
        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("Departure Airport: " + flight.getDepartureAirport());
        System.out.println("Arrival Airport: " + flight.getArrivalAirport());
        System.out.println("Departure Date: " + flight.getDepartureDate());
    }

}

