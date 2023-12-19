package edu.asu.flightreservationsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private VBox forms;
    private ArrayList<TextField> firstNames = new ArrayList<TextField>();
    private ArrayList<TextField> lastNames = new ArrayList<TextField>();
    private ArrayList<TextField> ids = new ArrayList<TextField>();

    private Button submitButton = new Button("Submit");
    private Label alertLabel = new Label("please Enter all required information");
    private Pane createsmallform() {
        Pane form = new Pane();

        VBox.setMargin(form, new Insets(20, 20, 20, 20));

        Label firstName = new Label("First Name");
        firstName.getStyleClass().add("labela");
        firstName.setLayoutX(115);
        firstName.setLayoutY(37);



        TextField firstNameField = new TextField();
        firstNameField.setLayoutX(265);
        firstNameField.setLayoutY(47);


        Label lastName = new Label("Last Name");
        lastName.getStyleClass().add("labela");
        lastName.setLayoutX(115);
        lastName.setLayoutY(117);


        TextField lastNameField = new TextField();
        lastNameField.setLayoutX(265);
        lastNameField.setLayoutY(127);

        Label id = new Label("ID");
        id.getStyleClass().add("labela");
        id.setLayoutX(500);
        id.setLayoutY(37);


        TextField idField = new TextField();
        idField.setMinWidth(150);
        idField.setLayoutX(556);
        idField.setLayoutY(47);

        firstNames.add(firstNameField);
        lastNames.add(lastNameField);
        ids.add(idField);

        form.getChildren().addAll(firstName, firstNameField, lastName, lastNameField, id, idField);
        return form;
    }

    private void createform() {

        for (int i = 0; i < bookingData.getBookingData().getNumberOfPassengers(); i++) {
            Pane p = createsmallform();
            p.getStyleClass().add("pane");
            forms.getChildren().add(p);
        }
        forms.getChildren().add(alertLabel);
        alertLabel.setVisible(false);
        alertLabel.getStyleClass().add("alertlabel");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createform();
        forms.setSpacing(10);
        submitButton.setMinWidth(100);
        submitButton.setPadding(new Insets(20));
        submitButton.getStyleClass().add("backbutton");
        submitButton.setOnAction(e -> {
            try {
                AddDatas(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        forms.setPadding(new Insets(20));
        forms.getChildren().add(submitButton);

    }

    private void AddDatas(ActionEvent event) throws IOException {
        if(!validate()){
            alertLabel.setVisible(true);
            return;
        }
        for (int i = 0; i < firstNames.size(); i++) {
            Integer ID = Integer.parseInt(ids.get(i).getText());
            Passenger passenger = new Passenger(firstNames.get(i).getText(), lastNames.get(i).getText(), ID.intValue());

            Ticket ticket = new Ticket(passenger, bookingData.getBookingData().getFlight().getSeatPrice(bookingData.getBookingData().getFlightClass()));
            bookingData.getBookingData().addTicket(ticket);
        }
        SwitchToSeatSelectionScene(event);
    }
    private void SwitchToSeatSelectionScene(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FlightSeatsPage flightSeatsPage= new FlightSeatsPage();
        flightSeatsPage.flightSeatsPage(stage);
    }

    @FXML
    private void SwitchToSelectScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FlightSearch.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private boolean validate(){
        for(int i=0;i<firstNames.size();i++){
            if(firstNames.get(i).getText().isEmpty()||lastNames.get(i).getText().isEmpty()||ids.get(i).getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

}
