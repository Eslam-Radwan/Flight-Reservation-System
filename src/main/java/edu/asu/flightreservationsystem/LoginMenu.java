package edu.asu.mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

public interface LoginMenu {
    default ApplicationUser loginMenu(ArrayList<ApplicationUser> appUsers)
    {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Username: ");
            String username = input.next();
            System.out.print("Password: ");
            String password = input.next();
            for (ApplicationUser appUserCheck : appUsers) {
                if (appUserCheck.getUsername().equals(username) && appUserCheck.getPassword().equals(password)) {
                    return appUserCheck;
                }
            }
            System.out.println("Incorrect username or password");
        }while(true);

    }
}
