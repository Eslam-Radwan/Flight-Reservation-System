package edu.asu.flightreservationsystem;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginPage {


        private Button loginButton;
        private TextField usernameTextField;
        private PasswordField passwordField;
        private Button signupButton;
        private ApplicationUser appUser;


        public void loginPage(Stage primaryStage, ArrayList<ApplicationUser> appUsers) {

            GridPane grid = layout();


            loginButton.setOnAction(e -> {
                if(usernameTextField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
                    showError(primaryStage,"Please enter the username and the password");
                }
                else {
                     boolean check = isValidLogin(primaryStage,usernameTextField.getText(),passwordField.getText(),appUsers);
                     if(check){
                         if(appUser instanceof User){

                         }
                         if(appUser instanceof Admin){

                         }
                     }
                     else {
                         showError(primaryStage,"The username or the password is wrong");
                     }
                }

            });

            signupButton.setOnAction(e -> {

            });

            Scene scene = new Scene(grid, primaryStage.getWidth(), primaryStage.getHeight());

            primaryStage.setScene(scene);

            primaryStage.show();
        }

        private void openSignupPage(Stage primaryStage) {
            SignupInterface1 signupInterface = new SignupInterface1();
            signupInterface.start(new Stage());
        }

        private boolean isValidLogin(Stage primaryStage,String username, String password,ArrayList<ApplicationUser> appUsers) {
            for (ApplicationUser appUserCheck : appUsers) {
                if (appUserCheck.getUsername().equals(username) && appUserCheck.getPassword().equals(password)) {
                    appUser = appUserCheck;
                    return true;
                }
            }
            return false;
        }

        private static void showError(Stage primaryStage, String message) {
            Label errorLabel = new Label(message);
            errorLabel.setStyle("-fx-text-fill: red;");
            GridPane.setConstraints(errorLabel, 0, 4, 2, 1);
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setPadding(new Insets(10, 0, 0, 0));
            ((GridPane) primaryStage.getScene().getRoot()).getChildren().add(errorLabel);
        }


    private GridPane layout() {
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

        Label frsLabel = new Label("Login");
        frsLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        grid.add(frsLabel, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
        grid.add(usernameLabel, 0, 1);

        usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
        grid.add(passwordLabel, 0, 2);

        passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        loginButton = new Button("Login");
        signupButton = new Button("Signup");

        loginButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
        signupButton.setStyle("-fx-background-color: #008CBA; -fx-text-fill: white;");

        grid.add(loginButton, 0, 3);
        grid.add(signupButton, 1, 3);

        return grid;
    }


}
