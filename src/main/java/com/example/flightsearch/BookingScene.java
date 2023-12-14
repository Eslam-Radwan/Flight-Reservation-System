package com.example.flightsearch;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingScene implements Initializable {

    private BookingData bookingData = BookingData.getInstane();
    @FXML
    private VBox forms = new VBox();
    private ArrayList<TextField> firstNames = new ArrayList<>();
    private ArrayList<TextField> lastNames = new ArrayList<>();
    private ArrayList<TextField> ids = new ArrayList<>();
    @FXML
    private Button submitButton=new Button();
    private VBox createsmallform() {
        VBox form = new VBox();

        VBox.setMargin(form, new Insets(20, 20, 20, 20));

        Label firstName = new Label("First Name");
        TextField firstNameField = new TextField();
        firstNameField.setMinWidth(100);
        Label lastName = new Label("Last Name");
        TextField lastNameField = new TextField();
        lastNameField.setMinWidth(100);
        Label id = new Label("ID");
        TextField idField = new TextField();
        idField.setMinWidth(100);
        Label phone = new Label("Phone no.");
        TextField phoneField = new TextField();

        firstNames.add(firstNameField);
        lastNames.add(lastNameField);
        ids.add(idField);

        form.getChildren().addAll(firstName, firstNameField, lastName, lastNameField, id, idField, phone, phoneField);
        return form;
    }

    private void createform() {

        for (int i = 0; i < bookingData.getBookingData().getNumberOfPassengers(); i++) {
            forms.getChildren().add(createsmallform());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createform();
        forms.setSpacing(10);
        submitButton.setMinWidth(100);
        submitButton.setPadding(new Insets(20));
        forms.setPadding(new Insets(20));
        forms.getChildren().add(submitButton);
    }
    @FXML
    private void AddDatas(ActionEvent event) throws IOException {
        for (int i = 0; i < firstNames.size(); i++) {
            Integer ID = Integer.parseInt(ids.get(i).getText());
            Passenger passenger = new Passenger(firstNames.get(i).getText(), lastNames.get(i).getText(), ID.intValue());

            Ticket ticket = new Ticket(passenger, bookingData.getBookingData().getFlight().getSeatPrice(bookingData.getBookingData().getFlightClass()));
            bookingData.getBookingData().addTicket(ticket);
        }
        SwitchToSeatSelectionScene(event);
    }
    private void SwitchToSeatSelectionScene(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FlightSeatsPage flightSeatsPage= new FlightSeatsPage();
        flightSeatsPage.start(stage);
    }


}
