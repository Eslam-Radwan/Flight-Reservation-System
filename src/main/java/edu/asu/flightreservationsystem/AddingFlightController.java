package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static edu.asu.flightreservationsystem.WorkFlow.Flights;

public class AddingFlightController implements Initializable {
    @FXML
    private TextField flightNumber;
    @FXML
    private TextField departureAirport;
    @FXML
    private TextField arrivalAirport;
    @FXML
    private DatePicker departureDate;
    @FXML
    private TextField economySeatPrice;
    @FXML
    private TextField businessSeatPrice;
    @FXML
    private TextField firstClassSeatPrice;
    @FXML
    private HBox hboxTime1;
    @FXML
    private HBox hboxTime2;
    private Spinner<Integer> hourSpinner1;
    private Spinner<Integer> hourSpinner2;
    private Spinner<Integer> minuteSpinner1;
    private Spinner<Integer> minuteSpinner2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hourSpinner1 = new Spinner<>();
        hourSpinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));
        hourSpinner2 = new Spinner<>();
        hourSpinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));

        minuteSpinner1 = new Spinner<>();
        minuteSpinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        minuteSpinner2 = new Spinner<>();
        minuteSpinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));

        hourSpinner1.setEditable(true);
        minuteSpinner1.setEditable(true);
        hourSpinner2.setEditable(true);
        minuteSpinner2.setEditable(true);

        hourSpinner1.setPromptText("Hours");
        hourSpinner2.setPromptText("Hours");
        minuteSpinner1.setPromptText("Minutes");
        minuteSpinner2.setPromptText("Minutes");

        hourSpinner1.setPrefWidth(75);
        hourSpinner2.setPrefWidth(75);
        minuteSpinner1.setPrefWidth(75);
        minuteSpinner2.setPrefWidth(75);


        hboxTime1.getChildren().addAll(hourSpinner1,minuteSpinner1);
        hboxTime2.getChildren().addAll(hourSpinner2,minuteSpinner2);


    }

    public void addFlightButton(ActionEvent event) throws IOException {
        Admin.addFlight(Integer.parseInt(flightNumber.getText()),
                        arrivalAirport.getText(),
                        departureAirport.getText(),
                         LocalTime.of(hourSpinner1.getValue(),minuteSpinner1.getValue()),
                          LocalTime.of(hourSpinner2.getValue(),minuteSpinner2.getValue()),
                          departureDate.getValue(),
                         Double.parseDouble(economySeatPrice.getText()),
                          Double.parseDouble(businessSeatPrice.getText()),
                          Double.parseDouble(firstClassSeatPrice.getText()));


        Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("AdminAddFlight.css").toExternalForm());
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
    public void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
