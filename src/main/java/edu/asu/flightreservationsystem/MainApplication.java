package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application implements UploadData, LoadData{
    @Override
    public void start(Stage stage) throws IOException {
        loadData();
        stage.setTitle("Flight Reservation System");
        stage.setWidth(900);
        stage.setHeight(700);
        stage.setResizable(false);
        stage.setOnCloseRequest(e -> uploadData());
        WorkFlow workFlow = new WorkFlow();
        workFlow.work(stage);

    }

    public static void main(String[] args) {
//        File file = new File("src/main/resources/Background.jpeg");
//        System.out.println(file.exists());
        launch();
    }
}