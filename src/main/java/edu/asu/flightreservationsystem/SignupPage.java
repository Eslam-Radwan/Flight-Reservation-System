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
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static edu.asu.flightreservationsystem.WorkFlow.appUsers;

public class SignupPage {


        public void signupPage(Stage primaryStage,Scene loginScene,GridPane loginLayout) {
            GridPane grid = layout(primaryStage,loginScene,loginLayout);
            loginScene.setRoot(grid);
        }
        private GridPane layout(Stage primaryStage, Scene loginScene, GridPane loginLayout){

            GridPane grid = new GridPane();

            grid.setPadding(new Insets(20, 20, 20, 20));
            grid.setVgap(8);
            grid.setHgap(10);
            grid.setAlignment(Pos.CENTER); // Center content in the grid

            Image backgroundImage = new Image("SignUpBackground.jpeg");
            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT
            );

            // Set the background to the grid
            grid.setBackground(new Background(background));



            Label firstNameLabel = new Label("First Name:");
            firstNameLabel.setStyle("-fx-text-fill: white;");
            GridPane.setConstraints(firstNameLabel, 0, 1);

            TextField firstNameInput = new TextField();
            GridPane.setConstraints(firstNameInput, 1, 1);
            firstNameInput.setPromptText("First Name");

            Label lastNameLabel = new Label("Last Name:");
            lastNameLabel.setStyle("-fx-text-fill: white;");
            GridPane.setConstraints(lastNameLabel, 0, 2);

            TextField lastNameInput = new TextField();
            GridPane.setConstraints(lastNameInput, 1, 2);
            lastNameInput.setPromptText("Last Name");


            // Username Label
            Label usernameLabel = new Label("Username:");
            usernameLabel.setStyle("-fx-text-fill: white;");
            GridPane.setConstraints(usernameLabel, 0, 3);


            // Username Input
            TextField usernameInput = new TextField();
            GridPane.setConstraints(usernameInput, 1, 3);
            usernameInput.setPromptText("User Name");

            // Password Label
            Label passwordLabel = new Label("Password:");
            passwordLabel.setStyle("-fx-text-fill: white;");
            GridPane.setConstraints(passwordLabel, 0, 4);


            // Password Input
            PasswordField passwordInput = new PasswordField();
            GridPane.setConstraints(passwordInput, 1, 4);

            // Email Label
            Label emailLabel = new Label("Email:");
            emailLabel.setStyle("-fx-text-fill: white;");
            GridPane.setConstraints(emailLabel, 0, 5);

            // Email Input
            TextField emailInput = new TextField();
            GridPane.setConstraints(emailInput, 1, 5);
            emailInput.setPromptText("Email");

            // Sign Up Button
            Button signUpButton = new Button("Sign Up");
            signUpButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
            GridPane.setConstraints(signUpButton, 1, 6, 2,1); // Centered and spanning two columns
            signUpButton.setOnAction(e -> {
                boolean check = signUpButtonClicked(primaryStage, firstNameInput, lastNameInput, usernameInput, passwordInput, emailInput);
                if(check) {
                    try {
                        loginScene.setRoot(loginLayout);
                    } catch (Exception exp) {
                        System.out.println(exp);
                    }
                }
            });

            // Add controls to the grid
            grid.getChildren().addAll(firstNameLabel,firstNameInput,lastNameLabel,lastNameInput, usernameLabel, usernameInput, passwordLabel, passwordInput, emailLabel, emailInput, signUpButton);
            return grid;
        }

        private boolean signUpButtonClicked(Stage primaryStage, TextField firstNameInput,TextField lastNameInput, TextField usernameInput, PasswordField passwordInput,TextField emailInput) {
            User user = new User();
            user.setFirstName(firstNameInput.getText());
            user.setLastName(lastNameInput.getText());
            user.setUsername(usernameInput.getText());
            user.setPassword(passwordInput.getText());
            user.setEmailAddress(emailInput.getText());
            if(firstNameInput.getText().trim().isEmpty() || lastNameInput.getText().trim().isEmpty() || usernameInput.getText().trim().isEmpty() || passwordInput.getText().trim().isEmpty() || emailInput.getText().trim().isEmpty()){
                showError(primaryStage,"Please enter the fileds");
                return false;
            }
            else {
                appUsers.add(user);
                return true;
            }

        }

    private static void showError(Stage primaryStage, String message) {
        Label errorLabel = new Label(message);
        errorLabel.setStyle("-fx-text-fill: red;");
        GridPane.setConstraints(errorLabel, 0, 7, 2, 1);
        errorLabel.setAlignment(Pos.CENTER);
        errorLabel.setPadding(new Insets(10, 0, 0, 0));
        ((GridPane) primaryStage.getScene().getRoot()).getChildren().add(errorLabel);
    }


}

