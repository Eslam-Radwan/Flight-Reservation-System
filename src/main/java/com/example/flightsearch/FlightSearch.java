package com.example.flightsearch;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FlightSearch implements Initializable {
    @FXML
    private TextField departureAirport;
    @FXML
    private TextField arrivalAirport;
    @FXML
    private DatePicker departureDate;
    @FXML
    private RadioButton firstClass;
    @FXML
    private RadioButton economicClass;
    @FXML
    private RadioButton businessClass;
    @FXML
    private Spinner<Integer> numOfPassengers;
    private BookingData bookingData = BookingData.getInstane();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        bookingData.setBookingData(new Booking());
        bookingData.getBookingData().setFlight(new Flight());
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        numOfPassengers.setValueFactory(valueFactory);
    }

    @FXML
    private void ClickSearchButton(ActionEvent event) throws IOException {
        if (DataInputValidation()) {
            Alert_Box alertBox = new Alert_Box();
            alertBox.display("Warning!", "Please fill all the data inputs!");
        } else {
            bookingData.getBookingData().getFlight().setArrivalAirport(arrivalAirport.getCharacters().toString());
            bookingData.getBookingData().getFlight().setDepartureAirport(departureAirport.getCharacters().toString());
            bookingData.getBookingData().getFlight().setDepartureDate(departureDate.getValue());
            bookingData.getBookingData().setNumberOfPassengers(numOfPassengers.getValue().intValue());
            if (economicClass.isSelected()) bookingData.getBookingData().setFlightClass(0);
            else if (businessClass.isSelected()) bookingData.getBookingData().setFlightClass(1);
            else bookingData.getBookingData().setFlightClass(2);
            SwitchToSelectScene(event);
        }
    }

    private boolean DataInputValidation() {
        return departureAirport.getCharacters().toString().isEmpty() || arrivalAirport.getCharacters().toString().isEmpty()
                || departureDate.getEditor().getCharacters().toString().isEmpty() || (!firstClass.isSelected() && !businessClass.isSelected() && !economicClass.isSelected());
    }

    @FXML
    private void SwitchToSelectScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FlightSelection.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
