package edu.asu.flightreservationsystem;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static edu.asu.flightreservationsystem.WorkFlow.appUsers;

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
    private BookingData booking = BookingData.getInstane();
    private UserData user = UserData.getInstance();

    @FXML
    ImageView profile;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        booking.setBookingData(new Booking());
        booking.getBookingData().setFlight(new Flight());
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        numOfPassengers.setValueFactory(valueFactory);
        profile.setImage(new Image("/Default_pfp.svg.png"));

        profile.setOnMouseClicked(event -> {
            try {
                SwitchToProfileScene(event);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception according to your needs
            }
        });
    }

    @FXML
    private void ClickSearchButton(ActionEvent event) throws IOException {
        if (DataInputValidation()) {
            Alert_Box alertBox = new Alert_Box();
            alertBox.display("Warning!", "Please fill all the data inputs!");
        } else {
            booking.getBookingData().getFlight().setArrivalAirport(arrivalAirport.getCharacters().toString());
            booking.getBookingData().getFlight().setDepartureAirport(departureAirport.getCharacters().toString());
            booking.getBookingData().getFlight().setDepartureDate(departureDate.getValue());
            booking.getBookingData().setNumberOfPassengers(numOfPassengers.getValue().intValue());
            if (economicClass.isSelected()) booking.getBookingData().setFlightClass(0);
            else if (businessClass.isSelected()) booking.getBookingData().setFlightClass(1);
            else booking.getBookingData().setFlightClass(2);
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

    @FXML
    private void SwitchToProfileScene(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void logoutButton(ActionEvent event) throws IOException {
        LoginPage login = new LoginPage();
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        login.loginPage(stage);
    }

}