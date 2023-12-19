package edu.asu.flightreservationsystem;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

import static edu.asu.flightreservationsystem.WorkFlow.Flights;

public class FlightSelect implements Initializable {

    @FXML
    private TextField flightFrom;
    @FXML
    private TextField flightTo;
    @FXML
    private TextField departureDate;
    @FXML
    private Label textFromFlight;
    @FXML
    private Label textToFlight;
    @FXML
    private Text departureTime;
    @FXML
    private Text arrivalTime;
    @FXML
    private TextField totalPrice;
    @FXML
    private Button nextFlight;
    @FXML
    private Button previousFlight;
    @FXML
    private Button bookButton;

    @FXML
    private Label warningLabel;
    @FXML
    private Label from;
    @FXML
    private Label to;
    @FXML
    private Label date;
    @FXML
    private Label total;


    private BookingData bookingData = BookingData.getInstane();
    private int iterator;
    private ArrayList<Flight> selectedFlights;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iterator = 0;
        warningLabel.setVisible(false);

        selectedFlights = new ArrayList<>();

        for (Flight flights : Flights) {
            if (bookingData.getBookingData().getFlight().equals(flights) && bookingData.getBookingData().getNumberOfPassengers() <= flights.getNumberOfAvailableSeat(bookingData.getBookingData().getFlightClass())) {
                selectedFlights.add(flights);
            }
        }

        selectedFlights.sort(new Flight() );

        if (!selectedFlights.isEmpty()) {
            SetFirstFlight();
        } else {
            warningLabel.setVisible(true);
            nextFlight.setVisible(false);
            previousFlight.setVisible(false);
            bookButton.setVisible(false);

            flightFrom.setVisible(false);
            flightTo.setVisible(false);
            departureDate.setVisible(false);
            departureTime.setVisible(false);
            arrivalTime.setVisible(false);
            textFromFlight.setVisible(false);
            textToFlight.setVisible(false);

            from.setVisible(false);
            to.setVisible(false);
            total.setVisible(false);
            totalPrice.setVisible(false);
            date.setVisible(false);



        }
        if (selectedFlights.size() == 1 || selectedFlights.isEmpty()) {
            nextFlight.setVisible(false);
            previousFlight.setVisible(false);
        }
        if(iterator==0){
            previousFlight.setVisible(false);
        }
    }

    @FXML
    private void NextFlight() {
        if (iterator + 1 < selectedFlights.size()) {
            SetNextFlight();
        }
        if (iterator == selectedFlights.size() - 1)
            nextFlight.setVisible(false);
        if (iterator >= 0)
            previousFlight.setVisible(true);

    }

    @FXML
    private void PreviousFlight() {
        if (iterator - 1 >= 0) {
            SetPreviousFlight();
        }
        if (iterator < selectedFlights.size())
            nextFlight.setVisible(true);
        if (iterator == 0)
            previousFlight.setVisible(false);
    }

    @FXML
    private void SwitchToBookingScene(ActionEvent event) throws Exception {
        bookingData.getBookingData().setFlight(selectedFlights.get(iterator));
        Parent root = FXMLLoader.load(getClass().getResource("BookingScene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SwitchToSearchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FlightSearch.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    private void SetFirstFlight() {
        flightFrom.setText(selectedFlights.get(iterator).getDepartureAirport().getAirportCity());
        flightTo.setText(selectedFlights.get(iterator).getArrivalAirport().getAirportCity());
        departureDate.setText(selectedFlights.get(iterator).getDepartureDate().toString());
        textFromFlight.setText(selectedFlights.get(iterator).getDepartureAirport().getAirportCity());
        textToFlight.setText(selectedFlights.get(iterator).getArrivalAirport().getAirportCity());
        departureTime.setText(selectedFlights.get(iterator).getDepartureTime().toString());
        arrivalTime.setText(selectedFlights.get(iterator).getArrivalTime().toString());
        double Price = (bookingData.getBookingData().getNumberOfPassengers()) * selectedFlights.get(iterator).getSeatPrice(bookingData.getBookingData().getFlightClass());
        totalPrice.setText(String.valueOf(Price));
    }

    private void SetNextFlight() {
        iterator++;
        SetFirstFlight();
    }

    private void SetPreviousFlight() {
        iterator--;
        SetFirstFlight();
    }




}
