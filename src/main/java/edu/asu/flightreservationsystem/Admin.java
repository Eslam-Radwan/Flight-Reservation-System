package edu.asu.mainPackage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static edu.asu.mainPackage.WorkFlow.Flights;

public class Admin extends ApplicationUser{

//    public Admin(ApplicationUser admin){
//        this.setFirstName(admin.getFirstName());
//        this.setLastName(admin.getLastName());
//        this.setPassword(admin.getPassword());
//        this.setEmailAddress(admin.getEmailAddress());
//        this.setFirstName(admin.getFirstName());
//        this.setUser(false);
//    }

    public static Flight addFlight() {
        Scanner input = new Scanner(System.in);

        Flight flight = new Flight();
        System.out.print("Flight Number: ");
        int flightNumber = input.nextInt();
        System.out.print("Departure Airport: ");
        String departureAirport = input.next();
        System.out.print("Arrival Airport: ");
        String arrivalAirport = input.next();
        System.out.print("Departure Date(YY MM DD): ");
        int Year = input.nextInt();
        int Month = input.nextInt();
        int Day = input.nextInt();
        LocalDate departureDate = LocalDate.of(Year,Month,Day);
        System.out.print("Departure Time(HH MM): ");
        int Hours = input.nextInt();
        int Minutes = input.nextInt();
        LocalTime departureTime = LocalTime.of(Hours,Minutes);
        System.out.print("Arrival Time(HH MM): ");
        Hours = input.nextInt();
        Minutes = input.nextInt();
        LocalTime arrivalTime = LocalTime.of(Hours,Minutes);



        flight.setFlightNumber(flightNumber);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureDate(departureDate);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);

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
        int numberOfFlight = input.nextInt();

        System.out.println("choose the seat class(0 for economy, 1 for business, 2 for first class): ");
        int seatClass = input.nextInt();

        Seat[][] Seats = Flights.get(numberOfFlight).getSeats(seatClass);
        displaySeats(Seats);

        System.out.println("Select the row and column you want to edit(e.g. 4B,3C): ");
        int row = input.nextInt();
        char column = input.next().charAt(0);
        Flights.get(numberOfFlight).getSeats(seatClass);
        if(Seats[row][(int)(column - 'a')].getSeatAvailability()) {
            Seats[row][(int) (column - 'a')].setSeatAvailability(false);
        }
        else {
            Seats[row][(int) (column - 'a')].setSeatAvailability(true);
        }

        //changeSeatAvailability(row,column,Flights.get(numberOfFlight));
    }

    private static void displayFlights(){
        for(int i = 0; i < Flights.size(); i++){
            System.out.print('[' + (i + 1) + ']');
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
        char a = 'a';
        for (int i = 0; i < 6; i++) {
            System.out.printf("%s ", a + i);
        }
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

