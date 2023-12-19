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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentScene implements Initializable {
    @FXML
    private TextField paymentamount=new TextField();
    @FXML
    private RadioButton visa,paypal,mastercard;
    @FXML
    private Button confirmPayment;
    @FXML
    private TextField number;
    @FXML
    private TextField date;
    @FXML
    private TextField cvv;
    @FXML
    private Label alertLabel;
    private BookingData bookingData = BookingData.getInstane();
    private UserData userData = UserData.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paymentamount.setText( Double.toString(bookingData.getBookingData().getPayment().getPaymentAmount()) );
    }
    public String GetPayMethod(ActionEvent event){
        if(mastercard.isSelected()){
            return "mastercard";
        }
        else {
            return "visa";
        }
    }
    private void SelectPaypal(){

    }
    @FXML
    private void SwitchToPaymentSuccess(ActionEvent event) throws IOException {
        if(!validate()){
            alertLabel.setVisible(true);
            return;
        }
        //add data in arrays
        bookingData.getBookingData().setBookingStatus("completed");
        bookingData.getBookingData().getFlight().setNumberOfAvailableSeat(bookingData.getBookingData().getFlightClass(), bookingData.getBookingData().getNumberOfPassengers());
        userData.getUserData().getBookings().add(bookingData.getBookingData());
        bookingData.getBookingData().putSeatsInFlight();

        Parent root = FXMLLoader.load(getClass().getResource("paymentSuccess.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean validate(){

            if(number.getText().isEmpty()||date.getText().isEmpty()||cvv.getText().isEmpty()){
                return false;
            }

        return true;
    }

}
