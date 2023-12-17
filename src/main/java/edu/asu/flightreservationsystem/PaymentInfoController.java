package edu.asu.flightreservationsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentInfoController implements PassengerInfoDisplay, Initializable {
    private BookingData bookingData = BookingData.getInstane();
    @FXML
    Label DBookingId;
    @FXML
    VBox passengers;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(int i=0;i<bookingData.getBookingData().getNumberOfPassengers();i++){
        passengers.getChildren().add(onePassenger(bookingData.getBookingData().getTicketinfo().get(i)));
        }
        DBookingId.setText(String.valueOf(bookingData.getBookingData().getBookingID()));
       // passengers.setSpacing(200);
    }
}
