package edu.asu.mainPackage;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Flight {
    private int flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate departureDate;
    private double[] seatPrice;
    private Seat[][] economySeats;
    private Seat[][] businessClass;
    private Seat[][] firstClass;
    private int[] numberOfAvailableSeat ;
//    ArrayList<String>  passenger = new ArrayList<>();

    public Flight(){
        seatPrice = new double[3];
        numberOfAvailableSeat = new int[]{30, 30, 30};
        economySeats = new Seat[5][6];
        businessClass = new Seat[5][6];
        firstClass = new Seat[5][6];
    }
    public int getNumberOfAvailableSeat(int classType){
        return this.numberOfAvailableSeat[classType];
    }

    @Override
    public boolean equals(Object object){
        Flight flight = (Flight)object;
        if(this.departureAirport.equals(flight.departureAirport) && this.arrivalAirport.equals(flight.arrivalAirport) && this.departureDate.equals(flight.getDepartureDate())) {
            return true;
        }
        else {
            return false;
        }

    }


    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setSeatPrice(int seatClass,double price) {
        this.seatPrice[seatClass] = price;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }


    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public double getSeatPrice(int seatClass) {
        return seatPrice[seatClass];
    }

    public Seat[][] getSeats(int seatClass) {
        if(seatClass == 0){
            return economySeats;
        }
        else if(seatClass == 1){
            return businessClass;
        }
        else{
            return firstClass;
        }
    }


    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureDate=" + departureDate +
                '}';
    }
}
