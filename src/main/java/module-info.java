module com.example.flightsearch {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.asu.flightreservationsystem to javafx.fxml;
    exports edu.asu.flightreservationsystem;
}

