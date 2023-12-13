package edu.asu.mainPackage;

import java.util.Scanner;

public interface SeatSelection {
    default void seatSelection(Booking booking) {
        System.out.println("welcome to Seat selection:('+' sign means available seats)");
        int flightClass = booking.getFlightClass();
        Seat [][] selectedSeats=null;
        switch (flightClass) {
            case 0:
                selectedSeats=booking.getFlight().getSeats(0);
                break;
            case 1:
                selectedSeats=booking.getFlight().getSeats(1);
                break;
            case 2:
                selectedSeats=booking.getFlight().getSeats(2);
        }

        System.out.printf("  ");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%c ",(char) 'a' + i);
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < 6; j++) {
                if (selectedSeats[i][j].getSeatAvailability() == false) {
                    System.out.print("- ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println("please enter your seat row number and column character");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < booking.getNumberOfPassengers(); i++) {
            System.out.print("please enter your seat:");
            String s = input.nextLine();
            int row=(int) (s.charAt(0)-'1');
            int column=(int) (s.charAt(1) - 'a');
            selectedSeats[row][column].setSeatAvailability(false);
            booking.setTicketseat(i, selectedSeats[row][column]);
        }

    }
}
