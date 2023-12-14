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

public class LoginPage {


        private Button loginButton;
        private TextField usernameTextField;
        private PasswordField passwordField;
        private Button signupButton;
        private ApplicationUser appUser;



        public void loginPage(Stage primaryStage, ArrayList<ApplicationUser> appUsers) {

            GridPane grid = layout();
            Scene scene = new Scene(grid);

            loginButton.setOnAction(e -> {
                if(usernameTextField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
                    showError(primaryStage,"Please enter the username and the password");
                }
                else {
                     boolean check = isValidLogin(primaryStage,usernameTextField.getText(),passwordField.getText(),appUsers);
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
                         showError(primaryStage,"The username or the password is wrong");
                     }
                }

            });

            signupButton.setOnAction(e -> {
                SignupPage signup = new SignupPage();
                signup.signupPage(primaryStage,scene,grid);
            });


            primaryStage.setScene(scene);

            primaryStage.show();
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

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


    try {
        Image backgroundImage = new Image("Background.jpeg");
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

    private void goToSearchPage(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FlightSearch.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }
    private void goToAdminPage(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminMainMenu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

}
