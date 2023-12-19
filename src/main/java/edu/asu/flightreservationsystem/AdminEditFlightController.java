package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static edu.asu.flightreservationsystem.WorkFlow.Flights;

public class AdminEditFlightController implements Initializable{
    @FXML
    private TextField flightNumber;
    @FXML
    private TextField arrivalAirport ;
    @FXML
    private TextField departureAirport ;
    @FXML
    private DatePicker departureDate ;
    @FXML
    private TextField economySeatPrice ;
    @FXML
    private TextField businessSeatPrice ;
    @FXML
    private TextField firstClassSeatPrice ;
    @FXML
    private Button flightNumberButton;
    @FXML
    private Button arrivalAirportButton;
    @FXML
    private Button departureAirportButton;
    @FXML
    private Button departureDateButton;
    @FXML
    private Button economySeatPriceButton;
    @FXML
    private Button businessSeatPriceButton;
    @FXML
    private Button firstClassSeatPriceButton;
    @FXML
    private HBox hbox1;
    @FXML
    private HBox hbox2;
    private Spinner<Integer>hourSpinner1;
    private Spinner<Integer>hourSpinner2;
    private Spinner<Integer>minuteSpinner1;
    private Spinner<Integer>minuteSpinner2;
    private static int index;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unEditable();
        buttonFunctions();
        flightNumber.setText(String.valueOf(Flights.get(this.index).getFlightNumber()));
        departureAirport.setText(Flights.get(this.index).getDepartureAirport().getAirportCity());
        arrivalAirport.setText(Flights.get(this.index).getArrivalAirport().getAirportCity());
        departureDate.setValue(Flights.get(this.index).getDepartureDate());
        economySeatPrice.setText(String.valueOf(Flights.get(this.index).getSeatPrice(0)));
        businessSeatPrice.setText(String.valueOf(Flights.get(this.index).getSeatPrice(1)));
        firstClassSeatPrice.setText(String.valueOf(Flights.get(this.index).getSeatPrice(2)));


        hourSpinner1 = new Spinner<>();
        hourSpinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, Flights.get(this.index).getDepartureTime().getHour()));
        hourSpinner2 = new Spinner<>();
        hourSpinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, Flights.get(this.index).getArrivalTime().getHour()));

        minuteSpinner1 = new Spinner<>();
        minuteSpinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, Flights.get(this.index).getDepartureTime().getMinute()));
        minuteSpinner2 = new Spinner<>();
        minuteSpinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, Flights.get(this.index).getArrivalTime().getMinute()));
        Button edit1 = new Button("Edit");
        Button edit2 = new Button("Edit");
        edit1.setOnAction(e -> {
            hourSpinner1.setDisable(false);
            minuteSpinner1.setDisable(false);
            hourSpinner1.setEditable(true);
            minuteSpinner1.setEditable(true);
        });
        edit2.setOnAction(e -> {
            hourSpinner2.setDisable(false);
            minuteSpinner2.setDisable(false);
            hourSpinner2.setEditable(true);
            minuteSpinner2.setEditable(true);
        });
        hourSpinner1.setDisable(true);
        hourSpinner2.setDisable(true);
        minuteSpinner1.setDisable(true);
        minuteSpinner2.setDisable(true);

        hourSpinner1.setPromptText("Hours");
        hourSpinner2.setPromptText("Hours");
        minuteSpinner1.setPromptText("Minutes");
        minuteSpinner2.setPromptText("Minutes");

        hourSpinner1.setPrefWidth(75);
        hourSpinner2.setPrefWidth(75);
        minuteSpinner1.setPrefWidth(75);
        minuteSpinner2.setPrefWidth(75);

        hbox1.getChildren().addAll(hourSpinner1,minuteSpinner1,edit1);
        hbox2.getChildren().addAll(hourSpinner2,minuteSpinner2,edit2);



    }
    private void unEditable(){
        flightNumber.setDisable(true);
        departureDate.setDisable(true);
        departureAirport.setDisable(true);
        arrivalAirport.setDisable(true);
        economySeatPrice.setDisable(true);
        businessSeatPrice.setDisable(true);
        firstClassSeatPrice.setDisable(true);
    }

    private void buttonFunctions(){
        flightNumberButton.setOnAction(e -> flightNumber.setDisable(false));
        departureDateButton.setOnAction(e -> departureDate.setDisable(false));
        departureAirportButton.setOnAction(e -> departureAirport.setDisable(false));
        arrivalAirportButton.setOnAction(e -> arrivalAirport.setDisable(false));
        economySeatPriceButton.setOnAction(e -> economySeatPrice.setDisable(false));
        businessSeatPriceButton.setOnAction(e -> businessSeatPrice.setDisable(false));
        firstClassSeatPriceButton.setOnAction(e -> firstClassSeatPrice.setDisable(false));
    }

    public void confirmButton(ActionEvent event) throws IOException {
        Admin.editFlight(index,Integer.parseInt(flightNumber.getText()),
                departureAirport.getText(),
                arrivalAirport.getText(),
                LocalTime.of(hourSpinner1.getValue(),minuteSpinner1.getValue()),
                LocalTime.of(hourSpinner2.getValue(),minuteSpinner2.getValue()),
                departureDate.getValue(),
                Double.parseDouble(economySeatPrice.getText()),
                Double.parseDouble(businessSeatPrice.getText()),
                Double.parseDouble(firstClassSeatPrice.getText()));



        Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
        Scene scene = new Scene(root);
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
    public void deleteButton(ActionEvent event) throws IOException {
//        Flights.remove(index);
        Admin.deleteFlight(index);
        backButton(event);

    }

    public static void setIndex(int i){
        index = i;
    }
}