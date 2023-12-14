package edu.asu.flightreservationsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPage {
    public void adminMainMenu(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminMainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
