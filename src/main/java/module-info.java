module com.example.flightsearch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flightsearch to javafx.fxml;
    exports com.example.flightsearch;
}