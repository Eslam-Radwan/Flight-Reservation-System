package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMainMenuController {

    public void addFlight(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
        Scene scene = new Scene(root);
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        System.out.println("2");
    }

    public void editFlight(){

    }
}
