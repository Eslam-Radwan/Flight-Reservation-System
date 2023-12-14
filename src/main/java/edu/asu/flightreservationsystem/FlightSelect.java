package com.example.flightsearch;

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
import java.util.ResourceBundle;

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
    private ImageView warningImage;
    @FXML
    private Label warningLabel;


    private BookingData bookingData = BookingData.getInstane();
    private int iterator;
    private ArrayList<Flight> selectedFlights;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iterator = 0;
        warningImage.setVisible(false);
        warningLabel.setVisible(false);

        selectedFlights = new ArrayList<>();

        for (Flight flights : ArbitraryData()) {
            if (bookingData.getBookingData().getFlight().getDepartureAirport().equals(flights.getDepartureAirport()) && bookingData.getBookingData().getFlight().getArrivalAirport().equals(flights.getArrivalAirport())
                    && bookingData.getBookingData().getFlight().getDepartureDate().equals(flights.getDepartureDate()) && bookingData.getBookingData().getNumberOfPassengers() <= flights.getNumberOfAvailableSeat(bookingData.getBookingData().getFlightClass())) {
                selectedFlights.add(flights);
            }
        }
        if (!selectedFlights.isEmpty()) {
            SetFirstFlight();
        } else {
            nextFlight.setVisible(false);
            previousFlight.setVisible(false);
            bookButton.setVisible(false);
            warningImage.setVisible(true);
            warningLabel.setVisible(true);
        }
        if (selectedFlights.size() == 1 || selectedFlights.isEmpty()) {
            nextFlight.setVisible(false);
            previousFlight.setVisible(false);
        }

    }

    @FXML
    private void NextFlight() {
        if (iterator + 1 < selectedFlights.size()) {
            SetNextFlight();
        }
        if (iterator == selectedFlights.size() - 1) nextFlight.setVisible(false);
        if (iterator >= 0) previousFlight.setVisible(true);

    }

    @FXML
    private void PreviousFlight() {
        if (iterator - 1 >= 0) {
            SetPreviousFlight();
        }
        if (iterator < selectedFlights.size()) nextFlight.setVisible(true);
        if (iterator == 0) previousFlight.setVisible(false);
    }

    @FXML
    private void SwitchToBookingScene(ActionEvent event) throws Exception {

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
        flightFrom.setText(selectedFlights.get(iterator).getDepartureAirport());
        flightTo.setText(selectedFlights.get(iterator).getArrivalAirport());
        departureDate.setText(selectedFlights.get(iterator).getDepartureDate().toString());
        textFromFlight.setText(selectedFlights.get(iterator).getDepartureAirport());
        textToFlight.setText(selectedFlights.get(iterator).getArrivalAirport());
        departureTime.setText(selectedFlights.get(iterator).getDepartureTime().toString());
        arrivalTime.setText(selectedFlights.get(iterator).getArrivalTime().toString());
        double Price = (bookingData.getBookingData().getNumberOfPassengers()) * selectedFlights.get(iterator).getSeatPrice(bookingData.getBookingData().getFlightClass());
        totalPrice.setText(String.valueOf(Price));
    }

    private void SetNextFlight() {
        iterator++;
        flightFrom.setText(selectedFlights.get(iterator).getDepartureAirport());
        flightTo.setText(selectedFlights.get(iterator).getArrivalAirport());
        departureDate.setText(selectedFlights.get(iterator).getDepartureDate().toString());
        textFromFlight.setText(selectedFlights.get(iterator).getDepartureAirport());
        textToFlight.setText(selectedFlights.get(iterator).getArrivalAirport());
        departureTime.setText(selectedFlights.get(iterator).getDepartureTime().toString());
        arrivalTime.setText(selectedFlights.get(iterator).getArrivalTime().toString());
        double Price = (bookingData.getBookingData().getNumberOfPassengers()) * selectedFlights.get(iterator).getSeatPrice(bookingData.getBookingData().getFlightClass());
        totalPrice.setText(String.valueOf(Price));
    }

    private void SetPreviousFlight() {
        iterator--;
        flightFrom.setText(selectedFlights.get(iterator).getDepartureAirport());
        flightTo.setText(selectedFlights.get(iterator).getArrivalAirport());
        departureDate.setText(selectedFlights.get(iterator).getDepartureDate().toString());
        textFromFlight.setText(selectedFlights.get(iterator).getDepartureAirport());
        textToFlight.setText(selectedFlights.get(iterator).getArrivalAirport());
        departureTime.setText(selectedFlights.get(iterator).getDepartureTime().toString());
        arrivalTime.setText(selectedFlights.get(iterator).getArrivalTime().toString());
        double Price = (bookingData.getBookingData().getNumberOfPassengers()) * selectedFlights.get(iterator).getSeatPrice(bookingData.getBookingData().getFlightClass());
        totalPrice.setText(String.valueOf(Price));
    }

    private ArrayList<Flight> ArbitraryData() {
        Flight fl1 = new Flight();
        fl1.setDepartureAirport("Cairo Internation Airport");
        fl1.setArrivalAirport("Luxur Internation Airport");
        fl1.setDepartureDate(LocalDate.now());
        fl1.setDepartureTime(LocalTime.of(10, 12));
        fl1.setArrivalTime(LocalTime.of(19, 25));

        Flight fl2 = new Flight();
        fl2.setDepartureAirport("Tokyo Internation Airport");
        fl2.setArrivalAirport("USA Internation Airport");
        fl2.setDepartureDate(LocalDate.now());
        fl2.setDepartureTime(LocalTime.now());
        fl2.setArrivalTime(LocalTime.of(11, 25));

        Flight fl3 = new Flight();
        fl3.setDepartureAirport("Test1");
        fl3.setArrivalAirport("Test2");
        fl3.setDepartureDate(LocalDate.now());
        fl3.setDepartureTime(LocalTime.of(11, 55));
        fl3.setArrivalTime(LocalTime.of(10, 25));
        fl3.setSeatPrice(bookingData.getBookingData().getFlightClass(), 1100);


        Flight fl4 = new Flight();
        fl4.setDepartureAirport("Test1");
        fl4.setArrivalAirport("Test2");
        fl4.setDepartureDate(LocalDate.now());
        fl4.setDepartureTime(LocalTime.of(15, 30));
        fl4.setArrivalTime(LocalTime.of(11, 25));
        fl4.setSeatPrice(bookingData.getBookingData().getFlightClass(), 90);


        ArrayList<Flight> availableFlights = new ArrayList<>();
        availableFlights.add(fl1);
        availableFlights.add(fl2);
        availableFlights.add(fl3);
        availableFlights.add(fl4);
        return availableFlights;
    }
}
