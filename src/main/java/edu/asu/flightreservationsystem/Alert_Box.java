package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

public class Alert_Box {
    public void display(String title, String message) {
        Stage window = new Stage();

        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);


        Label label = new Label(message);
        Button ClosedButton = new Button("Close Window");
        ClosedButton.setOnAction(e -> window.close());

        Font labelFont = Font.font("Verdana", FontWeight.EXTRA_BOLD, 13);
        label.setFont(labelFont);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, ClosedButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 220, 100);
        window.setScene(scene);
        window.showAndWait();

    }
}
