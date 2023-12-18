package edu.asu.flightreservationsystem;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public interface PassengerInfoDisplay {

    default public HBox onePassenger(Ticket t1){
        HBox onePassenger=new HBox();
        Label passengerName=new Label(t1.getPassenger().getFirstName()+" "+t1.getPassenger().getLastName());
        Label passengerId=new Label(String.valueOf(t1.getPassenger().getID()));
        Label seatNumber=new Label(String.valueOf(t1.getPassengerSeat().getSeatNumber()));
        Line separator=new Line(0,0 ,300,0);
        onePassenger.setSpacing(200);
        Pane e=new Pane(passengerName,passengerId,seatNumber,separator);

        e.setPrefWidth(900);
        e.setPrefHeight(70);

        passengerName.setLayoutX(165);
        passengerName.setLayoutY(29);

        passengerId.setLayoutX(450);
        passengerId.setLayoutY(29);

        seatNumber.setLayoutX(668);
        seatNumber.setLayoutY(29);

        separator.setLayoutX(470);
        separator.setLayoutY(70);
        separator.setStartX(-345);
        separator.setEndX(321);
        onePassenger.getChildren().add(e);


        onePassenger.setAlignment(Pos.CENTER);
        return onePassenger;
    }
}
