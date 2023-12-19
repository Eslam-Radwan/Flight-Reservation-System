package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) {


        stage.setTitle("Flight Reservation System");
        stage.setWidth(915);
        stage.setHeight(700);
        stage.setResizable(false);
        stage.getIcons().add(new Image("airplane.png"));
        WorkFlow workFlow = new WorkFlow();
        workFlow.work(stage);

    }

    public static void main(String[] args) {
        launch();
    }
}
