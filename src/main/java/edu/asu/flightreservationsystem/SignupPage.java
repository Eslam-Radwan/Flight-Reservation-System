package edu.asu.flightreservationsystem;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SignupPage {

        public void signupPage(Stage primaryStage) {
            Image backgroundImage = new Image("back.jpg");

            BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
            BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            Background backgroundObject = new Background(background);

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setBackground(backgroundObject);

            Label signupLabel = new Label("Signup");
            signupLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

            grid.add(signupLabel, 0, 0, 2, 1);

            Label firstNameLabel = new Label("First Name:");
            firstNameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
            grid.add(firstNameLabel, 0, 1);

            TextField firstNameTextField = new TextField();
            grid.add(firstNameTextField, 1, 1);

            Label lastNameLabel = new Label("Last Name:");
            lastNameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
            grid.add(lastNameLabel, 0, 2);

            TextField lastNameTextField = new TextField();
            grid.add(lastNameTextField, 1, 2);

            Label usernameLabel = new Label("Username:");
            usernameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
            grid.add(usernameLabel, 0, 3);

            TextField usernameTextField = new TextField();
            grid.add(usernameTextField, 1, 3);

            Label emailLabel = new Label("Email Address:");
            emailLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
            grid.add(emailLabel, 0, 4);

            TextField emailTextField = new TextField();
            grid.add(emailTextField, 1, 4);

            Label passwordLabel = new Label("Password:");
            passwordLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
            grid.add(passwordLabel, 0, 5);

            PasswordField passwordField = new PasswordField();
            grid.add(passwordField, 1, 5);

            Button signupButton = new Button("Signup");
            signupButton.setStyle("-fx-background-color: #008CBA; -fx-text-fill: white;");
            grid.add(signupButton, 1, 6);

            signupButton.setOnAction(e -> {


            });


            Scene scene = new Scene(grid, primaryStage.getWidth(), primaryStage.getHeight());

            primaryStage.setScene(scene);

        }
}

