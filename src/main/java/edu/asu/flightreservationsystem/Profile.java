package edu.asu.flightreservationsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Iterator;

public class Profile implements Initializable{
    private UserData userData = UserData.getInstance();

    @FXML
    private Label username;
    @FXML
    private Label email;
    @FXML
    VBox vbox = new VBox();


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        username.setText(userData.getUserData().getFirstName()+" "+userData.getUserData().getLastName());
        email.setText(userData.getUserData().getEmailAddress());
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        vbox.setSpacing(30);
        for(int i=0;i<userData.getUserData().getBookings().size();i++){
            Pane p = createbookingpane(i);
            p.getStyleClass().add("pane");
            vbox.getChildren().add(p);
        }
        vbox.getStyleClass().add("vbox");
    }


    @FXML
    private Pane createbookingpane(int i){

        Button edit=new Button("Edit");
        Button delete = new Button("Delete");
        delete.setOnAction(e -> {
            try {
                handldelete(e, i);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        edit.setOnAction(e -> {
            try {
                BookingData.getInstane().setBookingData(UserData.getInstance().getUserData().getBookings().get(i));
                SwitchToBookingEdit(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Pane bookingpane = new Pane();

        bookingpane.setPrefWidth(850);
        Label from = new Label("From:");
        from.getStyleClass().add("labela");
        from.setLayoutX(28);
        from.setLayoutY(25);



        Label To = new Label("To:");
        To.setLayoutX(28);
        To.setLayoutY(114);
        To.getStyleClass().add("labela");

        Label Date = new Label("Date:");
        Date.setLayoutX(331);
        Date.setLayoutY(25);
        Date.getStyleClass().add("labela");

        Label Class = new Label("Class:");
        Class.setLayoutX(328);
        Class.setLayoutY(114);
        Class.getStyleClass().add("labela");

        Label total = new Label("Total payment:");
        total.setLayoutX(629);
        total.setLayoutY(114);
        total.getStyleClass().add("labelb");

        Label fromb = new Label(userData.getUserData().getBookings().get(i).getFlight().getDepartureAirport().getAirportCity());
        fromb.setLayoutX(146);
        fromb.setLayoutY(25);
        fromb.getStyleClass().add("labela");

        Label Tob = new Label(userData.getUserData().getBookings().get(i).getFlight().getArrivalAirport().getAirportCity());
        Tob.setLayoutX(112);
        Tob.setLayoutY(114);
        Tob.getStyleClass().add("labela");

        Label Dateb = new Label(userData.getUserData().getBookings().get(i).getFlight().getDepartureDate().toString());
        Dateb.setLayoutX(443);
        Dateb.setLayoutY(25);
        Dateb.getStyleClass().add("labela");

        Label classb = new Label(userData.getUserData().getBookings().get(i).getClassString());
        classb.setLayoutX(443);
        classb.setLayoutY(114);
        classb.getStyleClass().add("labela");

        Label totalb = new Label(Double.toString(userData.getUserData().getBookings().get(i).getPayment().getPaymentAmount()));
        totalb.setLayoutX(758);
        totalb.setLayoutY(114);
        totalb.getStyleClass().add("labelb");

        edit.setLayoutX(758);
        edit.setLayoutY(25);

        delete.setLayoutX(758);
        delete.setLayoutY(70);

        bookingpane.getChildren().addAll(from, To, Date, Class, total,fromb, Tob, Dateb, classb, totalb,edit, delete);

        return bookingpane;

    }

    @FXML
    private void SwitchToSelectScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FlightSearch.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    private void SwitchToBookingEdit(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("bookingEdit.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



// ...

    private void handldelete(ActionEvent e,int i) throws IOException {
        Booking booking = UserData.getInstance().getUserData().getBookings().get(i);
        for (int j = 0; j < booking.getNumberOfPassengers(); j++) {
            int row = booking.getTicketinfo().get(j).getPassengerSeat().getSeatRow();
            int col = booking.getTicketinfo().get(j).getPassengerSeat().getSeatColumn();
            booking.getFlight().getSeats(booking.getFlightClass())[row][col].setSeatAvailability(true);
            booking.getFlight().setNumberOfAvailableSeat(booking.getFlightClass(),-1);
        }
        UserData.getInstance().getUserData().getBookings().remove(i);
        SwitchToSelectScene(e);
    }


}
