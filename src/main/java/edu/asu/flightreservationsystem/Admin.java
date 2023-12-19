package edu.asu.flightreservationsystem;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;

import static edu.asu.flightreservationsystem.WorkFlow.Flights;

public class Admin extends ApplicationUser implements Serializable {

    @Override
    public void goToMainMenu(Stage primaryStage)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        }catch (IOException e){
            System.out.println("The AdminAddFlight.fxml file does not found");
        }
    }

    public static void addFlight(int flightNumber, String departureAirport, String arrivalAirport, LocalTime departureTime, LocalTime arrivalTime, LocalDate departureDate, Double economyPrice, Double businessClassPrice, Double firstClassPrice ){
    Flight flight = new Flight();
    flight.setFlightNumber(flightNumber);
    flight.setDepartureAirport(departureAirport);
    flight.setArrivalAirport(arrivalAirport);
    flight.setDepartureDate(departureDate);
    flight.setDepartureTime(departureTime);
    flight.setArrivalTime(arrivalTime);
    flight.setSeatPrice(0,economyPrice);
    flight.setSeatPrice(1,businessClassPrice);
    flight.setSeatPrice(2,firstClassPrice);

    Flights.add(flight);
}
    public static void editFlight(int index,int flightNumber,String departureAirport, String arrivalAirport,LocalTime departureTime,LocalTime arrivalTime, LocalDate departureDate,Double economyPrice, Double businessClassPrice, Double firstClassPrice ){
        Flight flight = Flights.get(index);
        flight.setFlightNumber(flightNumber);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureDate(departureDate);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setSeatPrice(0,economyPrice);
        flight.setSeatPrice(1,businessClassPrice);
        flight.setSeatPrice(2,firstClassPrice);

    }
    public static void deleteFlight(int index){
    Flights.remove(index);
    }
}

