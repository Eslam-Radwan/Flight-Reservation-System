package edu.asu.flightreservationsystem;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public interface PassengerInfoDisplay {

    default public HBox onePassenger(Ticket t1){
        HBox onePassenger=new HBox();
        Label passengerName=new Label(t1.getPassenger().getFirstName()+" "+t1.getPassenger().getLastName());
        Label passengerId=new Label(String.valueOf(t1.getPassenger().getID()));
        Label seatNumber=new Label(String.valueOf(t1.getPassengerSeat().getSeatNumber()));
        onePassenger.getChildren().addAll(passengerName ,passengerId,seatNumber);
        onePassenger.setSpacing(200);
        return onePassenger;
    }
}
