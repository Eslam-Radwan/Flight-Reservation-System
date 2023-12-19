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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingEditController implements Initializable, PassengerInfoDisplay{
    private Booking booking;

    @FXML
    Label totalAmount;
    @FXML
    Label departureAirport;
    @FXML
    Label arrivalAirport;
    @FXML
    Label departureTime;
    @FXML
    Label arrivalTime;
    @FXML
    Label flightNumber;
    @FXML
    VBox passengers;
    ArrayList<TextField> names = new ArrayList<>();
    ArrayList<TextField> ids = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        booking = BookingData.getInstane().getBookingData();

        for(int i=0;i<booking.getNumberOfPassengers();i++){
            passengers.getChildren().add(onePassenger(booking,i));
        }
        SetData();
    }

    public void SetData() {
        Flight bookedFlight = booking.getFlight();
        arrivalAirport.setText(bookedFlight.getArrivalAirport().getAirportCity());
        departureAirport.setText(bookedFlight.getDepartureAirport().getAirportCity());
        arrivalTime.setText(bookedFlight.getArrivalTime().toString());
        departureTime.setText(bookedFlight.getDepartureTime().toString());
        totalAmount.setText(Double.toString(booking.getPayment().getPaymentAmount()));
        flightNumber.setText("# " + String.valueOf(bookedFlight.getFlightNumber()));

    }


     public Pane onePassenger(Booking t1, int i){
        TextField passengerName=new TextField(t1.getTicketinfo().get(i).getPassenger().getFirstName()+" "+t1.getTicketinfo().get(i).getPassenger().getLastName());
        names.add(passengerName);
        TextField passengerId=new TextField(String.valueOf(t1.getTicketinfo().get(i).getPassenger().getID()));
        ids.add(passengerId);
        Label seatNumber=new Label(String.valueOf(t1.getTicketinfo().get(i).getPassengerSeat().getSeatNumber()));
         Button edit = new Button("Edit");
         edit.setOnAction(e -> handleEditclick(i));
         Button delete = new Button("Delete");
         delete.setOnAction(e -> handleDeleteClick(i));
//         edit.setOnAction(e -> UserData.getInstance().getUserData().editBooking());

        Line separator=new Line(0,0 ,300,0);
        Pane e=new Pane(passengerName,passengerId,seatNumber, edit, delete, separator);
        separator.getStyleClass().add("separator");
        //style
        passengerName.getStyleClass().add("name");
        passengerId.getStyleClass().add("id");
        seatNumber.getStyleClass().add("seat");
        e.getStyleClass().add("panePassenger");
         edit.getStyleClass().add("edit");
         delete.getStyleClass().add("delete");
        separator.setLayoutX(470);
        separator.setLayoutY(70);
        separator.setStartX(-345);
        separator.setEndX(321);
        return e;
    }

    private void handleEditclick(int i){
        String newname =names.get(i).getText();
        String[] names = newname.split(" ");
        int newmId = Integer.parseInt(ids.get(i).getText());
        booking.getTicketinfo().get(i).getPassenger().setFirstName(names[0]);
        booking.getTicketinfo().get(i).getPassenger().setLastName(names[1]);
        booking.getTicketinfo().get(i).getPassenger().setID(newmId);
    }
    private void handleDeleteClick(int i){
        int row = booking.getTicketinfo().get(i).getPassengerSeat().getSeatRow();
        int col = booking.getTicketinfo().get(i).getPassengerSeat().getSeatColumn();
        booking.getFlight().getSeats(booking.getFlightClass())[row][col].setSeatAvailability(true);
        booking.getTicketinfo().remove(i);
        booking.setNumberOfPassengers(booking.getNumberOfPassengers()-1);
        for (int j = passengers.getChildren().size() - 1; j >= 0; j--) {
            passengers.getChildren().remove(j);
        }

        // Re-add passengers after removal
        for (int j = 0; j < booking.getNumberOfPassengers(); j++) {
            passengers.getChildren().add(onePassenger(booking, j));
        }
    }

    @FXML
    private void SwitchToProfileScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
