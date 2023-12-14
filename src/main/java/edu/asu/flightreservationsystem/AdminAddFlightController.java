package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminAddFlightController implements Initializable {

    @FXML
    VBox vbox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i < WorkFlow.Flights.size(); i++){
            Pane p = makeFlightPane(WorkFlow.Flights.get(i));
            vbox.getChildren().add(p);
        }
    }

    public void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AdminMainMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        System.out.println("3");
    }
    public void addFlightButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddingFlight.fxml"));
        Scene scene = new Scene(root);
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    private Pane makeFlightPane(Flight flight){
        Pane pane = new Pane();
        Label arrivalAirport = new Label(flight.getArrivalAirport());
        Label departureAirport = new Label(flight.getDepartureAirport());
        Label flightNumber = new Label(Integer.toString(flight.getFlightNumber()));
        Label departureTime = new Label(flight.getDepartureTime().toString());
        Label arrivalTime = new Label(flight.getArrivalTime().toString());
        Label economySeatPrice = new Label(Double.toString(flight.getSeatPrice(0)));
        Label businessSeatPrice = new Label(Double.toString(flight.getSeatPrice(1)));
        Label firstClassSeatPrice = new Label(Double.toString(flight.getSeatPrice(2)));
        pane.getChildren().addAll(arrivalAirport,departureAirport);
        return pane;

    }

}
