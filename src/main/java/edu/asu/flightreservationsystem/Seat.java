package edu.asu.flightreservationsystem;


import java.io.Serializable;

public class Seat implements Serializable {

    private int seatNumber ;
    private int seatClass ;
    private boolean seatAvailability ;
    private int seatRow ;
    private int seatColumn ;

    public Seat(){}
    public Seat (int seatNumber, int seatClass , boolean seatAvailability , int seatRow , int seatColumn ){
        this.seatNumber = seatNumber ;
        this.seatClass = seatClass ;
        this.seatAvailability = seatAvailability ;
        this.seatColumn=seatColumn ;
        this.seatRow = seatRow ;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatClass(int seatClass) {
        this.seatClass = seatClass;
    }

    public void setSeatAvailability(boolean seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public int getSeatClass() {
        return seatClass;
    }

    public boolean getSeatAvailability() {
        return seatAvailability;
    }
    public int getSeatColumn() {
        return seatColumn;
    }

    public int getSeatRow() {
        return seatRow;
    }
}