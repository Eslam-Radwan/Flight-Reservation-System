package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentInfoController implements PassengerInfoDisplay, Initializable {
    private BookingData bookingData = BookingData.getInstane();
    @FXML
    Label totalAmount;
    @FXML
    Label departureAirport;
    @FXML
    Label arrivalAirport;
    @FXML
    Label departureTime;
    @FXML
    Label arrivalTime;
    @FXML
    Label flightNumber;
    @FXML
    VBox passengers;

    private Payment unvalidPayment=new Payment(bookingData.getBookingData().getNumberOfPassengers(),bookingData.getBookingData().getFlight().getSeatPrice(bookingData.getBookingData().getFlightClass()));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookingData.getBookingData().setPayment(unvalidPayment);
        SetData();

        for(int i=0;i<bookingData.getBookingData().getNumberOfPassengers();i++){
        passengers.getChildren().add(onePassenger(bookingData.getBookingData().getTicketinfo().get(i)));
        }
       // passengers.setSpacing(200);

    }
    public void SetData(){
        Flight bookedFlight=bookingData.getBookingData().getFlight();
        arrivalAirport.setText(bookedFlight.getArrivalAirport());
        departureAirport.setText(bookedFlight.getDepartureAirport());
        arrivalTime.setText(bookedFlight.getArrivalTime().toString());
        departureTime.setText(bookedFlight.getDepartureTime().toString());
        totalAmount.setText( Double.toString(bookingData.getBookingData().getPayment().getPaymentAmount()) );
        flightNumber.setText("# "+String.valueOf(bookedFlight.getFlightNumber()));

    }
    @FXML
    private void SwitchToPayment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("payment.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
