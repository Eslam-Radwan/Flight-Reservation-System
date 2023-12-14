package edu.asu.flightreservationsystem;


import java.util.Scanner;

public interface SignupMenu {
    default void signupMenu(ApplicationUser user){
        Scanner input = new Scanner(System.in);
        System.out.print("First Name: ");
        user.setFirstName(input.next());
        System.out.print("Last Name: ");
        user.setLastName(input.next());
        System.out.print("Username: ");
        user.setUsername(input.next());
        System.out.print("Email Address: ");
        user.setEmailAddress(input.next());
        System.out.print("Password: ");
        user.setPassword(input.next());
    }
}
