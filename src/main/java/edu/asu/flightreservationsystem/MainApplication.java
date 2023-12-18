package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application implements UploadData, LoadData{
    @Override
    public void start(Stage stage) {
        loadData();
        System.out.println(WorkFlow.airports);

        stage.setTitle("Flight Reservation System");
        stage.setWidth(915);
        stage.setHeight(700);
        stage.setResizable(false);
        stage.setOnCloseRequest(e -> uploadData());
        WorkFlow workFlow = new WorkFlow();
        workFlow.work(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
