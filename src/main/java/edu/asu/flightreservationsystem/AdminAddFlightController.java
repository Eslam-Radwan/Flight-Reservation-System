package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class AdminAddFlightController implements Initializable {

    @FXML
    VBox vbox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(int i = 0; i < WorkFlow.Flights.size(); i++){
            Pane p = makeFlightPane(WorkFlow.Flights.get(i));
            vbox.getChildren().add(p);
        }
    }

    public void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AdminMainMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        System.out.println("3");
    }
    public void addFlightButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddingFlight.fxml"));
        Scene scene = new Scene(root);
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    private Pane makeFlightPane(Flight flight){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        Pane pane = new Pane();
        Pane pricePane = new Pane();
        Line line = makeLine();
        Label flightNumberLabel = new Label("Flight Number");
        Label arrivalAirport = new Label(flight.getArrivalAirport());
        Label departureAirport = new Label(flight.getDepartureAirport());
        Label flightNumber = new Label('#' + Integer.toString(flight.getFlightNumber()));
        Label departureTime = new Label(flight.getDepartureTime().toString());
        Label arrivalTime = new Label(flight.getArrivalTime().toString());
        Label departureDate = new Label(flight.getDepartureDate().toString());
        Label economySeatPrice = new Label(numberFormat.format(flight.getSeatPrice(0)) + " EGP For Economy Seat");
        Label businessSeatPrice = new Label(numberFormat.format(flight.getSeatPrice(1)) + " EGP For Business Seat");
        Label firstClassSeatPrice = new Label(numberFormat.format(flight.getSeatPrice(2)) + " EGP For First Class Seat");
        Label economyAvailableSeats = new Label(Integer.toString(flight.getNumberOfAvailableSeat(0)));
        Label businessAvailableSeats = new Label(Integer.toString(flight.getNumberOfAvailableSeat(1)));
        Label firstClassAvailableSeats = new Label(Integer.toString(flight.getNumberOfAvailableSeat(2)));
        Image image = new Image("airplaneicon.png");
        ImageView imageView = new ImageView(image);


        imageView.setFitWidth(47);
        imageView.setFitHeight(52);
        imageView.setLayoutX(185);
        imageView.setLayoutY(97);
        flightNumberLabel.setLayoutX(20);
        flightNumberLabel.setLayoutY(15);
        flightNumber.setLayoutX(140);
        flightNumber.setLayoutY(7);
        arrivalAirport.setLayoutX(325);
        arrivalAirport.setLayoutY(90);
        departureAirport.setLayoutX(15);
        departureAirport.setLayoutY(90);
        line.setLayoutX(255.0);
        line.setLayoutY(75.0);
        departureTime.setLayoutX(40);
        departureTime.setLayoutY(70);
        arrivalTime.setLayoutX(355);
        arrivalTime.setLayoutY(70);
        departureDate.setLayoutX(305);
        departureDate.setLayoutY(10);

        pricePane.setLayoutX(455);
        pricePane.setLayoutY(8);
        economySeatPrice.setLayoutX(14);
        economySeatPrice.setLayoutY(14);
        businessSeatPrice.setLayoutX(14);
        businessSeatPrice.setLayoutY(69);
        firstClassSeatPrice.setLayoutX(14);
        firstClassSeatPrice.setLayoutY(125);
        economyAvailableSeats.setLayoutX(305);
        economyAvailableSeats.setLayoutY(20);
        businessAvailableSeats.setLayoutX(305);
        businessAvailableSeats.setLayoutY(75);
        firstClassAvailableSeats.setLayoutX(305);
        firstClassAvailableSeats.setLayoutY(131);



        economySeatPrice.setPrefWidth(365);
        economySeatPrice.setPrefHeight(45);
        businessSeatPrice.setPrefWidth(365);
        businessSeatPrice.setPrefHeight(45);
        firstClassSeatPrice.setPrefWidth(365);
        firstClassSeatPrice.setPrefHeight(45);


        arrivalAirport.getStyleClass().add("AirportLabel");
        departureAirport.getStyleClass().add("AirportLabel");
        arrivalTime.getStyleClass().add("TimeLabel");
        departureTime.getStyleClass().add("TimeLabel");
        pane.getStyleClass().add("MainPane");
        pricePane.getStyleClass().add("PricePane");
        economySeatPrice.getStyleClass().add("PriceLabel");
        businessSeatPrice.getStyleClass().add("PriceLabel");
        firstClassSeatPrice.getStyleClass().add("PriceLabel");
        flightNumberLabel.getStyleClass().add("FlightNumberLabel");
        flightNumber.getStyleClass().add("FlightNumber");
        departureDate.getStyleClass().add("departureDate");
        economyAvailableSeats.getStyleClass().add("AvailableSeats");
        businessAvailableSeats.getStyleClass().add("AvailableSeats");
        firstClassAvailableSeats.getStyleClass().add("AvailableSeats");




        pricePane.getChildren().addAll(economySeatPrice,businessSeatPrice,firstClassSeatPrice,economyAvailableSeats,businessAvailableSeats,firstClassAvailableSeats);

        pane.getChildren().addAll(pricePane,flightNumberLabel,flightNumber,arrivalAirport,departureAirport,line,departureTime,arrivalTime,departureDate,imageView);
        return pane;

    }

    private Line makeLine(){
        Line line = new Line();
        line.setStartX(-130.0);
        line.setStartY(48.0);
        line.setEndX(52.0);
        line.setEndY(48.0);
        line.setOpacity(0.8);
        line.setStroke(javafx.scene.paint.Color.WHITE);
        line.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        line.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.ROUND);
        line.setStrokeWidth(10.0);
        return line;
    }

}
