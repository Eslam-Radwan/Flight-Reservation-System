package edu.asu.mainPackage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

import static edu.asu.mainPackage.WorkFlow.Flights;

public class Admin extends ApplicationUser implements Serializable {

//    public Admin(ApplicationUser admin){
//        this.setFirstName(admin.getFirstName());
//        this.setLastName(admin.getLastName());
//        this.setPassword(admin.getPassword());
//        this.setEmailAddress(admin.getEmailAddress());
//        this.setFirstName(admin.getFirstName());
//        this.setUser(false);
//    }

    public static Flight addFlight() {
        int flightNumber;
        int Year;
        int Month;
        int Day;
        double economyPrice;
        double firstClassPrice;
        double businessClassPrice;
        int Hours;
        int Minutes;

        Scanner input = new Scanner(System.in);

        Flight flight = new Flight();
        System.out.print("Flight Number: ");
        flightNumber = input.nextInt();
        System.out.print("Departure Airport: ");
        String departureAirport = input.next();
        System.out.print("Arrival Airport: ");
        String arrivalAirport = input.next();
        System.out.print("Departure Date(YY MM DD): ");
        Year = input.nextInt();
        Month = input.nextInt();
        Day = input.nextInt();
        LocalDate departureDate = LocalDate.of(Year,Month,Day);
        System.out.print("Departure Time(HH MM): ");
        Hours = input.nextInt();
        Minutes = input.nextInt();
        LocalTime departureTime = LocalTime.of(Hours,Minutes);
        System.out.print("Arrival Time(HH MM): ");
        Hours = input.nextInt();
        Minutes = input.nextInt();
        LocalTime arrivalTime = LocalTime.of(Hours,Minutes);

        System.out.print("price of Economy Seat");
        economyPrice=input.nextDouble();

        System.out.print("price of First Class Seat");
        firstClassPrice=input.nextDouble();

        System.out.print("price of Business Class Seat");
        businessClassPrice=input.nextDouble();

        flight.setFlightNumber(flightNumber);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureDate(departureDate);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setSeatPrice(0,economyPrice);
        flight.setSeatPrice(1,firstClassPrice);
        flight.setSeatPrice(2,businessClassPrice);

        return flight;

    }

    public static void updateFlight(){
        Scanner input = new Scanner(System.in);

        displayFlights();

        System.out.print("choose the number of flight: ");
        int numberOfFlight = input.nextInt() - 1;
        displayFlightInfo(Flights.get(numberOfFlight));

        System.out.print("what do you want to edit: ");
        int propertyToEdit = input.nextInt();

        if(propertyToEdit == 1) {
            System.out.print("Entre the new flight number: ");
            int newFlightNumber = input.nextInt();
            Flights.get(numberOfFlight).setFlightNumber(newFlightNumber);
        }
        if(propertyToEdit == 2) {
            System.out.print("Entre the new departure airport: ");
            String newDepartureAirport = input.next();
            Flights.get(numberOfFlight).setDepartureAirport(newDepartureAirport);
        }
        if(propertyToEdit == 3) {
            System.out.print("Entre the new arrival airport: ");
            String newArrivalAirport = input.next();
            Flights.get(numberOfFlight).setArrivalAirport(newArrivalAirport);
        }
        if(propertyToEdit == 4) {
            System.out.print("Entre the new departure date(YY MM DD): ");
            int Year = input.nextInt();
            int Month = input.nextInt();
            int Day = input.nextInt();
            LocalDate newDepartureDate = LocalDate.of(Year,Month,Day);
            Flights.get(numberOfFlight).setDepartureDate(newDepartureDate);
        }
        if(propertyToEdit == 5) {
            System.out.print("Entre the new departure time(HH MM): ");
            int Hours = input.nextInt();
            int Minutes = input.nextInt();
            LocalTime newDepartureTime = LocalTime.of(Hours,Minutes);
            Flights.get(numberOfFlight).setDepartureTime(newDepartureTime);
        }
        if(propertyToEdit == 6) {
            System.out.print("Entre the new arrival time(HH MM): ");
            int Hours = input.nextInt();
            int Minutes = input.nextInt();
            LocalTime newArrivalTime = LocalTime.of(Hours,Minutes);
            Flights.get(numberOfFlight).setDepartureTime(newArrivalTime);
        }


    }

    public static void deleteFlight() {
        Scanner input = new Scanner(System.in);

        displayFlights();

        System.out.print("choose the number of flight: ");
        int numberOfFlight = input.nextInt();
        Flights.remove(numberOfFlight); //if there is a delete method in arraylist
    }



    public static void changeSeatAvailability() {
        Scanner input = new Scanner(System.in);

        displayFlights();

        System.out.print("choose the number of flight: ");
        int numberOfFlight = input.nextInt()-1;

        System.out.println("choose the seat class(0 for economy, 1 for business, 2 for first class): ");
        int seatClass = input.nextInt();

        Seat[][] Seats = Flights.get(numberOfFlight).getSeats(seatClass);
        displaySeats(Seats);

        System.out.println("Select the row and column you want to edit(e.g. 4b,3c): ");
        String s = input.next();
        int row=(int) (s.charAt(0)-'1');
        int column=(int) (s.charAt(1) - 'a');


        Seats[row][column].setSeatAvailability(!Seats[row][column].getSeatAvailability());

    }

    private static void displayFlights(){
        for(int i = 0; i < Flights.size(); i++){
            System.out.print("[" + (i + 1) + "]");
            System.out.println(Flights.get(i));
            System.out.println("==============================");
        }
    }

    private static void displayFlightInfo(Flight flight){
        System.out.println("[1]Flight Number: " + flight.getFlightNumber());
        System.out.println("[2]Departure Airport: " + flight.getDepartureAirport());
        System.out.println("[3]Arrival Airport: " + flight.getArrivalAirport());
        System.out.println("[4]Departure Date: " + flight.getDepartureDate());
        System.out.println("[5]Departure Time: " + flight.getDepartureTime());
        System.out.println("[6]Arrival Time: " + flight.getArrivalTime());
    }

    private static void displaySeats(Seat[][] seats)
    {
        System.out.print("  ");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%c ",(char)'a' + i);
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < 6; j++) {
                if (seats[i][j].getSeatAvailability() == false) {
                    System.out.print("- ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }
}

