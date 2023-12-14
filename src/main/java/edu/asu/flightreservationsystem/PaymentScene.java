package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentScene implements Initializable {
    @FXML
    private TextField paymentAmount=new TextField();
    @FXML
    private RadioButton visa,paypal,mastercard;
    @FXML
    private Button confirmPayment;

    private BookingData bookingData = BookingData.getInstane();
    private Payment unvalidPayment=new Payment(bookingData.getBookingData().getNumberOfPassengers(),bookingData.getBookingData().getFlight().getSeatPrice(bookingData.getBookingData().getFlightClass()));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paymentAmount.setText( Double.toString( unvalidPayment.getPaymentAmount() ) );
    }
    public String GetPayMethod(ActionEvent event){
        if(paypal.isSelected()){
            return "paypal";
        }
        else if(mastercard.isSelected()){
            return "mastercard";
        }
        else {
            return "visa";
        }
    }
    @FXML
    private void SwitchToPaymentSuccess(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paymentSuccess.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
