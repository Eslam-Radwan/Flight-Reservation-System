package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class MainApplication extends Application implements UploadData, LoadData{
    @Override
    public void start(Stage stage) throws IOException {

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
        LocalTime t = LocalTime.of(20,12);
        System.out.println(t.toString());
        LocalDate d = LocalDate.of(2022,12,12);
        System.out.println(d.toString());

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        System.out.println(numberFormat.format(12345678));


//        File file = new File("src/main/resources/Background.jpeg");
//        System.out.println(file.exists());
        launch();
    }
}
