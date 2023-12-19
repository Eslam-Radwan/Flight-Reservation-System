package edu.asu.flightreservationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static edu.asu.flightreservationsystem.WorkFlow.appUsers;

public class LoginPage {


        private Button loginButton;
        private TextField usernameTextField;
        private PasswordField passwordField;
        private Button signupButton;
        private ApplicationUser appUser;

        private Label errorLabel = new Label();




    public void loginPage(Stage primaryStage) {

            GridPane grid = layout();
            Scene scene = new Scene(grid);

            loginButton.setOnAction(e -> {
                if(usernameTextField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
                    showError("Please enter the username and the password");
                }
                else {
                     boolean check = isValidLogin(usernameTextField.getText(),passwordField.getText());
                     if(check){
                         if(appUser instanceof User){
                             User user = (User)appUser;
                             UserData userData = UserData.getInstance();
                             userData.setUserData(user);
                             try {
                                 goToSearchPage(primaryStage);
                             } catch (IOException ex) {
                                 throw new RuntimeException(ex);
                             }
                         }
                         if(appUser instanceof Admin){
                            Admin admin = (Admin)appUser;
                            AdminData adminData = AdminData.getInstance();
                            adminData.setAdmin(admin);
                             try {
                                 goToAdminPage(primaryStage);
                             } catch (IOException ex) {
                                 throw new RuntimeException(ex);
                             }
                         }
                     }
                     else {
                         showError("The username or the password is wrong");
                     }
                }

            });

            signupButton.setOnAction(e -> {
                SignupPage signup = new SignupPage();
                signup.signupPage(primaryStage,scene,grid);
            });

            scene.getStylesheets().add(getClass().getResource("CommonStyling.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }


        private boolean isValidLogin(String username, String password) {
            for (ApplicationUser appUserCheck : appUsers) {
                if (appUserCheck.getUsername().equals(username) && appUserCheck.getPassword().equals(password)) {
                    appUser = appUserCheck;
                    return true;
                }
            }
            return false;
        }

        private  void showError(String message) {
            errorLabel.setText(message);
        }


    private GridPane layout() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


    try {
        Image backgroundImage = new Image("3386851.jpg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.REPEAT,   // Set the repeat type
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        grid.setBackground(new Background(background));
    }catch (Exception e){
        System.out.println(e);
    }

        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setAlignment(Pos.CENTER);
        errorLabel.setPadding(new Insets(10, 0, 0, 0));
        GridPane.setConstraints(errorLabel, 0, 4, 2, 1);


        Label frsLabel = new Label("Login");
        frsLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        grid.add(frsLabel, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");
        grid.add(usernameLabel, 0, 1);

        usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");
        grid.add(passwordLabel, 0, 2);

        passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        loginButton = new Button("Login");
        signupButton = new Button("Signup");

       // loginButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
        //signupButton.setStyle("-fx-background-color: #008CBA; -fx-text-fill: white;");

        grid.add(loginButton, 0, 3);
        grid.add(signupButton, 1, 3);
        grid.getChildren().add(errorLabel);

        return grid;
    }

    private void goToSearchPage(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FlightSearch.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }
    private void goToAdminPage(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminAddFlight.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

}
