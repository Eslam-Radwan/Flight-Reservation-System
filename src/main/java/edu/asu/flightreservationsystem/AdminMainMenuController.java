package edu.asu.flightreservationsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.asu.flightreservationsystem.WorkFlow.appUsers;

public class AdminMainMenuController {

    public void addFlight(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("AdminAddFlight.css").toExternalForm());
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void editFlight(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminEditFlight.fxml"));
        Scene scene = new Scene(root);
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    public void logoutButton(ActionEvent event) throws IOException {
        LoginPage login = new LoginPage();
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        login.loginPage(stage,appUsers);
    }
}
