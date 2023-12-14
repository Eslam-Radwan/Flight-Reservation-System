package edu.asu.flightreservationsystem;


import java.io.*;
import java.util.ArrayList;

public interface LoadData {
    default void loadData() {
        File users = new File("src/main/resources/users.txt");
        File flights = new File("src/main/resources/Flights.txt");
        ObjectInputStream userInputStream = null;
        ObjectInputStream flightsInputStream = null;
        try {
            userInputStream = new ObjectInputStream(new FileInputStream(users));
            WorkFlow.appUsers = (ArrayList<ApplicationUser>) userInputStream.readObject();
            userInputStream.close();
        } catch (ClassNotFoundException e) {

            System.out.println("File Not found");
            try {
                users.createNewFile();
            } catch (IOException exp) {
                System.out.println(exp);

            }
        } catch (IOException e) {
            System.out.println(e.toString());

        } finally {
            try {
                userInputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        }


        try {
            flightsInputStream = new ObjectInputStream(new FileInputStream(flights));
            WorkFlow.Flights = (ArrayList<Flight>) flightsInputStream.readObject();
            flightsInputStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("File Not found");

            try {
                flights.createNewFile();
            } catch (IOException exp) {
                System.out.println(exp);

            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                flightsInputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }
}