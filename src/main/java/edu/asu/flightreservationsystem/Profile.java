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
import java.util.ResourceBundle;

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
        username.setText(userData.getUserData().getFirstName()+userData.getUserData().getLastName());
        email.setText(userData.getUserData().getEmailAddress());
        for(int i=0;i<userData.getUserData().getBookings().size();i++){
            Pane p = createbookingpane(i);
            vbox.getChildren().add(p);
        }
    }


    @FXML
    private Pane createbookingpane(int i){


        Pane bookingpane = new Pane();
        Label from = new Label("From:");
        from.setLayoutX(28);
        from.setLayoutY(25);



        Label To = new Label("To:");
        To.setLayoutX(28);
        To.setLayoutY(114);


        Label Date = new Label("Date:");
        Date.setLayoutX(331);
        Date.setLayoutY(25);


        Label Class = new Label("Class:");
        Class.setLayoutX(328);
        Class.setLayoutY(114);


        Label total = new Label("Total payment:");
        total.setLayoutX(629);
        total.setLayoutY(114);


        Label fromb = new Label(userData.getUserData().getBookings().get(i).getFlight().getDepartureAirport());
        fromb.setLayoutX(146);
        fromb.setLayoutY(25);


        Label Tob = new Label(userData.getUserData().getBookings().get(i).getFlight().getArrivalAirport());
        Tob.setLayoutX(112);
        Tob.setLayoutY(114);


        Label Dateb = new Label(userData.getUserData().getBookings().get(i).getFlight().getDepartureDate().toString());
        Dateb.setLayoutX(443);
        Dateb.setLayoutY(25);


        Label classb = new Label(userData.getUserData().getBookings().get(i).getClassString());
        classb.setLayoutX(443);
        classb.setLayoutY(114);


        Label totalb = new Label(Double.toString(userData.getUserData().getBookings().get(i).getPayment().getPaymentAmount()));
        totalb.setLayoutX(697);
        totalb.setLayoutY(114);

        bookingpane.getChildren().addAll(from, To, Date, Class, total,fromb, Tob, Dateb, classb, totalb);

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


}
