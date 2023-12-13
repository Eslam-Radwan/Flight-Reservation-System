package edu.asu.mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

public interface UserWork {
    default int userWork(User user) {
        int choice;
        choice = userMenu();
        if (choice == 1) {

            Booking booking = new Booking();
            boolean bookingCheck = user.flightSearch(booking);
            if(bookingCheck){
                booking.setBookingID(user.getBookings().size() + 1);
                booking.setBookingStatus("pending");
                user.setBookings(user.bookingProcess(booking));
            }
            return 2;
        } else if (choice == 2) {
            while(profile(user) == 1){
                bookedFlights(user);
            }
            return 2;
        } else if (choice == 3) {
            return 1;
        } else if (choice == 4) {
            return 0;
        } else {
            System.out.println("UserWork out of range else");
            // out of the range
            // or
            // input string
        }
        return 2;
    }

    private int userMenu() {
        System.out.println("===============User Menu===============");
        System.out.println("[1]Search for a FLight");
        System.out.println("[2]Profile");
        System.out.println("[3]Logout");
        System.out.println("[4]Exit");
        System.out.print("Go To: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private int profile(User user) {
        System.out.println(user);
        System.out.println("[1]Booked Flights");
        System.out.println("[2]Back");
        Scanner input = new Scanner(System.in);
        System.out.print("Go To: ");
        int choice = input.nextInt();
        return choice;
    }

    private void bookedFlights(User user) {
        for (Booking booking : user.getBookings()) {
            System.out.println("Booking ID: " + booking.getBookingID());
            System.out.println("Number Of Passengers: " + booking.getNumberOfPassengers());
            System.out.println("Flight Class: " + booking.getFlightClass());
            System.out.println("Booking Status: " + booking.getBookingStatus());
            System.out.println(booking.getFlight());
            System.out.println("==============================");
        }
        System.out.println("[1]Back");
        Scanner input = new Scanner(System.in);
        System.out.print("Go To: ");
        int choice = input.nextInt();
        while(choice != 1){
            System.out.println("worng input");
            choice = input.nextInt();
        }
    }
}
