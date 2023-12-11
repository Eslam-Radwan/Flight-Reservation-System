package edu.asu.flightreservationsystem;
import javafx.application.Application;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Line;
        import javafx.scene.text.Font;
        import javafx.stage.Stage;
        import javafx.scene.*;
public class HelloApplication extends Application {
    private Scene mainScene;
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(50));
        setWallpaper(root);
        HBox topBox = new HBox();
        topBox.setSpacing(10);
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> goBackToPreviousScene(primaryStage));
        HBox.setMargin(backButton, new Insets(0, 0, 0, 10));
        backButton.setMinWidth(75);
        backButton.setTranslateX(650);
        Label frsLabel = new Label("FRS");
        HBox.setHgrow(frsLabel, Priority.ALWAYS);
        frsLabel.setTranslateX(350);
        frsLabel.setFont(new Font(30));
        HBox.setMargin(frsLabel, new Insets(0, 10, 0, 10));
        topBox.getChildren().add(frsLabel);
        topBox.getChildren().add(backButton);
        root.setTop(topBox);
        HBox profile = new HBox();
        Button profileButton = new Button("Profile");
        profileButton.setOnAction(event -> switchToProfile(primaryStage));
        profile.getChildren().add(profileButton);
        profileButton.setMinWidth(75);
        primaryStage.setResizable(false);
        root.setLeft(profile);
        VBox bottomBox = new VBox();
        bottomBox.setSpacing(10);
//        Button personalInfoButton = new Button("Personal Information");
//        personalInfoButton.setOnAction(event -> switchToAnotherScene(primaryStage, "Personal Information"));
//        bottomBox.getChildren().add(personalInfoButton);
//        personalInfoButton.setMinWidth(150);
        Button bookedFlightsButton = new Button("Booked Flights");
        bookedFlightsButton.setOnAction(event -> switchToBookedFlightsScene(primaryStage));
        bottomBox.getChildren().add(bookedFlightsButton);
        bookedFlightsButton.setMinWidth(150);
        Button settingsButton = new Button("Settings");
        settingsButton.setOnAction(event -> switchToSettings(primaryStage));
        bottomBox.getChildren().add(settingsButton);
        settingsButton.setMinWidth(150);
        root.setBottom(bottomBox);
        mainScene = new Scene(root, 900, 700);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Your JavaFX App");
        primaryStage.show();
    }
    private void goBackToPreviousScene(Stage primaryStage) {
        primaryStage.setScene(mainScene);
    }
    private void switchToAnotherScene(Stage primaryStage, String sceneName) {
        BorderPane sceneRoot = new BorderPane();
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> goBackToPreviousScene(primaryStage));
        javafx.scene.layout.HBox.setMargin(backButton, new Insets(0, 0, 0, 10));
        sceneRoot.setTop(new HBox(backButton));
        sceneRoot.setCenter(new Label("This is " + sceneName));
        Scene newScene = new Scene(sceneRoot, 900, 700);
        primaryStage.setScene(newScene);
    }
    private void switchToSettings(Stage primaryStage){
        BorderPane root = new BorderPane();
        setWallpaper(root);
        Label nameLabel = new Label("Name field input");
        root.setTop(nameLabel);
        nameLabel.setAlignment(Pos.TOP_CENTER);
        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(event -> primaryStage.setScene(mainScene));
        HBox topBox = new HBox(backButton);
        topBox.setPadding(new Insets(10));
        root.setRight(topBox);
        Label bookedFlightsLabel = new Label("Booked Flights");
        Button editButton = new Button("Edit");
        HBox bottomBox = new HBox(bookedFlightsLabel, editButton);
        bottomBox.setSpacing(10);
        root.setBottom(bottomBox);
        Scene scene = new Scene(root, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flight App");
        primaryStage.show();
    }
    private void switchToProfile(Stage primaryStage){
        BorderPane root = new BorderPane();
        setWallpaper(root);
        Label userProfileLabel = new Label("User Profile");
        userProfileLabel.setFont(new Font(30));
        HBox topCenterBox = new HBox(userProfileLabel);
        topCenterBox.setAlignment(Pos.CENTER);
        root.setTop(topCenterBox);
        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(event -> primaryStage.setScene(mainScene));
        HBox topBox = new HBox(backButton);
        topBox.setPadding(new Insets(10));
        root.setRight(topBox);
        VBox test = new VBox();
        test.setAlignment(Pos.CENTER);
        test.setSpacing(20);
        test.setPadding(new Insets(20));
        Label userNameLabel = new Label("User Name:");
        userNameLabel.setStyle("-fx-font-size: 18;");
        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-size: 18;");
        test.getChildren().addAll(userNameLabel, emailLabel);
        root.setCenter(test);
        Scene scene = new Scene(root, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flight App");
        primaryStage.show();
    }
    private void switchToBookedFlightsScene(Stage primaryStage) {
        BorderPane bookedFlightsRoot = new BorderPane();
        Button backFromBookedFlightsButton = new Button("Back");
        backFromBookedFlightsButton.setOnAction(event -> goBackToPreviousScene(primaryStage));
        javafx.scene.layout.HBox.setMargin(backFromBookedFlightsButton, new Insets(0, 0, 0, 10));
        bookedFlightsRoot.setTop(new HBox(backFromBookedFlightsButton));
        bookedFlightsRoot.setCenter(new Label("This is Booked Flights"));
        Scene bookedFlightsScene = new Scene(bookedFlightsRoot, 900, 700);
        primaryStage.setScene(bookedFlightsScene);
    }
    private void setWallpaper(BorderPane root){
        Image backgroundImage = new Image("file:src/ADHAM.jpeg");
        BackgroundImage backgroundImageObj = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(900, 700, false, false, false, false)
        );
        Background backgroundWithImage = new Background(backgroundImageObj);
        root.setBackground(backgroundWithImage);
        root.setPadding(new Insets(50));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
