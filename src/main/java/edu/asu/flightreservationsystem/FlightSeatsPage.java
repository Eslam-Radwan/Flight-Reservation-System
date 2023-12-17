package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class FlightSeatsPage {

    private BookingData bookingData = BookingData.getInstane();
    private ArrayList<String> passengers = new ArrayList<>();

    String imagePath1 = "/Seat1.png";
    Image image1 = new Image(imagePath1);
    String imagepath2 = "/Seat2.png";
    Image image2 = new Image(imagepath2);
    VBox vbox;
    int selectedseats = 0;
    ArrayList<Image> images = new ArrayList<>();
    private static final int ROWS = 5;
    private static final int SEATS_PER_ROW = 6;

    public void flightSeatsPage(Stage primaryStage) {
        try {

            CheckBox b1 = new CheckBox();
            Label label1 = new Label("pasenger info");
            b1.setSelected(true);

            CheckBox b2 = new CheckBox();
            b2.setSelected(true);
            Label label2 = new Label("seat selection");

            CheckBox b3 = new CheckBox();
            Label label3 = new Label("payment");

            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);


            Button next = new Button("Next");

            next.setOnAction(e -> {
                try {
                    SwitchToPaymentScene(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });


            next.setStyle("-fx-padding:20 20 20 20");
            next.setAlignment(Pos.CENTER_LEFT);


            HBox hbox = new HBox();
            hbox.setSpacing(20);
            hbox.getChildren().addAll(b1, label1, b2, label2, b3, label3, next);
            hbox.setAlignment(Pos.CENTER);
            label1.setStyle("-fx-font-size: 30; -fx-padding:0 20 0 0");
            label2.setStyle("-fx-font-size: 30; -fx-padding:0 20 0 0");
            label3.setStyle("-fx-font-size: 30; -fx-padding:0 0 0 0");


            for(Ticket tickets:bookingData.getBookingData().getTicketinfo()){
                passengers.add(tickets.getPassenger().getFirstName()+" "+tickets.getPassenger().getLastName());
            }

            vbox = createvbox(passengers);
            vbox.setAlignment(Pos.TOP_RIGHT);

            GridPane gridPane = createSeatGrid();
            gridPane.setAlignment(Pos.TOP_CENTER);

            BorderPane parent = new BorderPane();
            parent.setTop(hbox);
            parent.setCenter(gridPane);
            parent.setLeft(vbox);
//            parent.setTop(bottombox);


            String imagePath = "/Background.jpeg";
            Image backgroundImage = new Image(getClass().getResource(imagePath).toExternalForm()); // Replace with the path to your image
            parent.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));


            Scene scene = new Scene(parent, 900, 700);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void SwitchToPaymentScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PaymentInfo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    private GridPane createSeatGrid() {
        images.add(image1);
        images.add(image2);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30));
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < SEATS_PER_ROW; col++) {
                // Replace the button with an ImageView
                ImageView seatImageView = new ImageView(images.get(0));
                if (bookingData.getBookingData().getFlight().getSeats(bookingData.getBookingData().getFlightClass())[row][col].getSeatAvailability()) {
                    seatImageView.setImage(images.get(0));
                    int r = row;
                    int c = col;
//                    handleSeatClick(seatImageView, r, c)
                    seatImageView.setOnMouseClicked(event -> handleSeatClick(seatImageView, r, c));
                } else {
                    seatImageView.setImage(images.get(1));
                }

                seatImageView.setFitWidth(95);
                seatImageView.setFitHeight(95);

                gridPane.add(seatImageView, col, row);
            }
        }

        return gridPane;
    }


    private VBox createvbox(ArrayList<String> passengers) {

        VBox vBox = new VBox();
        Label title = new Label("passengers:");
        title.setStyle("-fx-font-size: 30; -fx-padding:0 0 20 20; -fx-font-weight: bold;");
        vBox.getChildren().add(title);
        for (int i = 0; i < passengers.size(); i++) {
            Label name = new Label(passengers.get(i));
            name.setStyle("-fx-font-size: 20; -fx-padding:0 0 20 10");
            vBox.getChildren().add(name);
        }
        return vBox;

    }

    private void handleSeatClick(ImageView seatImageView, int row, int col) {
        if (selectedseats < bookingData.getBookingData().getNumberOfPassengers() && bookingData.getBookingData().getFlight().getSeats(bookingData.getBookingData().getFlightClass())[row][col].getSeatAvailability()) {
            seatImageView.setImage(images.get(1));  // Set the new image when the seat is selected
            vbox.getChildren().get(selectedseats + 1).setDisable(true);
            bookingData.getBookingData().getFlight().getSeats(bookingData.getBookingData().getFlightClass())[row][col].setSeatAvailability(false);
            bookingData.getBookingData().getTicketinfo().get(selectedseats).setPassengerSeat(bookingData.getBookingData().getFlight().getSeats(bookingData.getBookingData().getFlightClass())[row][col]);
            selectedseats++;  // Increment the selected seats counter
        }
    }

}