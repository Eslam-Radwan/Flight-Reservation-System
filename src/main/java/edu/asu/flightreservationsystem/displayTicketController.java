package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class displayTicketController implements Initializable {
    @FXML
    private Label ticketNumber;
    @FXML
    private Label fullName;
    @FXML
    private Label from;
    @FXML
    private Label to;
    @FXML
    private Label departureTime;
    @FXML
    private Label arrivalTime;
    @FXML
    private Label ticketFare;
    @FXML
    private Label seatNumber;
    @FXML
    private Label seatClass;
    private static Ticket ticket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ticketNumber.setText(String.valueOf(ticket.getTicketNumber()));
        fullName.setText(ticket.getPassenger().getFirstName() + " " + ticket.getPassenger().getLastName());
        from.setText(ticket.getPassenger().getBookingInfo().getFlight().getDepartureAirport().getAirportCity());
        to.setText(ticket.getPassenger().getBookingInfo().getFlight().getArrivalAirport().getAirportCity());
        departureTime.setText(ticket.getPassenger().getBookingInfo().getFlight().getDepartureTime().toString());
        arrivalTime.setText(ticket.getPassenger().getBookingInfo().getFlight().getArrivalTime().toString());
        ticketFare.setText(String.valueOf(ticket.getTicketFare()));
        seatNumber.setText(String.valueOf(ticket.getPassengerSeat().getSeatNumber()));
        seatClass.setText(String.valueOf(ticket.getPassengerSeat().getSeatClass()));
    }
    public void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
