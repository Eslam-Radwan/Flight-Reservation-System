package edu.asu.flightreservationsystem;


import java.io.*;
import java.util.ArrayList;

public interface LoadData {
    default void loadData() {
        File users = new File("users.txt");
        File flights = new File("Flights.txt");
        try {
            ObjectInputStream userInputStream = new ObjectInputStream(new FileInputStream(users));
            WorkFlow.appUsers = (ArrayList<ApplicationUser>) userInputStream.readObject();
            userInputStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("11");
            System.out.println("File Not found");
            try {
                users.createNewFile();
            } catch (IOException exp) {
                System.out.println(exp);
                System.out.println("12");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("2");
        }


        try {
            ObjectInputStream flightsInputStream = new ObjectInputStream(new FileInputStream(flights));
            WorkFlow.Flights = (ArrayList<Flight>) flightsInputStream.readObject();
            flightsInputStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("File Not found");
            System.out.println("31");
            try {
                flights.createNewFile();
            } catch (IOException exp) {
                System.out.println(exp);
                System.out.println("32");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("4");
        }
    }
}