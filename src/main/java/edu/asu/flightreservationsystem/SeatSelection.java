package edu.asu.mainPackage;

import java.util.Scanner;

public interface SeatSelection {
    default void seatSelection(Booking booking) {
        System.out.println("welcome to Seat selection:('+' sign means available seats)");
        int flightClass = booking.getFlightClass();

        Seat[][] economySeats = booking.getFlight().getSeats(0);
        Seat[][] businessSeats = booking.getFlight().getSeats(1);
        Seat[][] firstClassSeats = booking.getFlight().getSeats(2);

        if (flightClass == 0) {
            char a = 'a';
            for (int i = 0; i < 6; i++) {
                System.out.printf("%s ", a + i);
            }
            for (int i = 0; i < 5; i++) {
                System.out.printf("%d ", i + 1);
                for (int j = 0; j < 6; j++) {
                    if (economySeats[i][j].getSeatAvailability() == false) {
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
                //booking.getFlight().getEconomySeats((int) s.charAt(0), (int) s.charAt(0) - 'a').setSeatAvailability(false);
                economySeats[(int) (s.charAt(0))][(int) (s.charAt(0) - 'a')].setSeatAvailability(false);
                Seat seat = new Seat();
                booking.setTicketseat(i, seat);
            }
        }
        else if (flightClass == 1) {
            char a = 'a';
            for (int i = 0; i < 6; i++) {
                System.out.printf("%s ", a + i);
            }
            for (int i = 0; i < 5; i++) {
                System.out.printf("%d ", i + 1);
                for (int j = 0; j < 6; j++) {
                    if (businessSeats[i][j].getSeatAvailability() == false) {
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
                //booking.getFlight().setEconomySeatsAvailability((int) s.charAt(0), (int) s.charAt(0) - 'a', 0);
                businessSeats[(int) (s.charAt(0))][(int) (s.charAt(0) - 'a')].setSeatAvailability(false);
                Seat seat = new Seat();
                booking.setTicketseat(i, seat);
            }
        }
        else if (flightClass == 2) {
            char a = 'a';
            for (int i = 0; i < 6; i++) {
                System.out.printf("%s ", a + i);
            }
            for (int i = 0; i < 5; i++) {
                System.out.printf("%d ", i + 1);
                for (int j = 0; j < 6; j++) {
                    if (firstClassSeats[i][j].getSeatAvailability() == false) {
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
                //booking.getFlight().setEconomySeatsAvailability((int) s.charAt(0), (int) s.charAt(0) - 'a', 0);
                firstClassSeats[(int) (s.charAt(0))][(int) (s.charAt(0) - 'a')].setSeatAvailability(false);
                Seat seat = new Seat();
                booking.setTicketseat(i, seat);
            }
        }


    }
}
