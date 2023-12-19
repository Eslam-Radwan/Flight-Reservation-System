package edu.asu.flightreservationsystem;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class User extends ApplicationUser implements Serializable {
    @Override
    public void goToMainMenu(Stage primaryStage) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("FlightSearch.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
         }catch (IOException e){
        System.out.println("The FlightSearch.fxml file does not found");
          }
    }

    private ArrayList<Booking> Bookings = new ArrayList<>();

    public void setBookings(Booking booking) {
        Bookings.add(booking);
    }

    public ArrayList<Booking> getBookings() {
        return Bookings;
    }

    @Override
    public String toString() {
        return "First Name: " + this.getFirstName() + " Last Name: " + this.getLastName() +
                " Username: " + this.getUsername() + " Email Address: " + this.getEmailAddress();
    }
}
