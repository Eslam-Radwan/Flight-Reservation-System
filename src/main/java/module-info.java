module edu.asu.flightreservationsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.asu.flightreservationsystem to javafx.fxml;
    exports edu.asu.flightreservationsystem;
}