package edu.asu.flightreservationsystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Flight implements Serializable ,Comparable, Comparator {
    private int flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate departureDate;
    private double[] seatPrice;
    private Seat[][] economySeats;
    private Seat[][] businessClass;
    private Seat[][] firstClass;
    private int[] numberOfAvailableSeat ;
//    ArrayList<String>  passenger = new ArrayList<>();

    public void setEconomySeats(int row, int col, Seat seat) {
        economySeats[row][col] = seat;
    }

    public void setBuisinesseats(int row, int col, Seat seat) {
        businessClass[row][col] = seat;
    }

    public void setFirstClassSeats(int row, int col, Seat seat) {
        firstClass[row][col] = seat;
    }
    public Flight(){
        seatPrice = new double[3];
        numberOfAvailableSeat = new int[]{30, 30, 30};
        //arrivalAirport=new Airport()
        economySeats = new Seat[5][6];
        for (int i=0;i<5;i++){
            for (int j=0;j<6;j++){
                economySeats[i][j]=new Seat(i*10+j,0,true,i,j);
            }
        }
        businessClass = new Seat[5][6];
        for (int i=0;i<5;i++){
            for (int j=0;j<6;j++){
                businessClass[i][j]=new Seat(i*10+j,1,true,i,j);
            }
        }
        firstClass = new Seat[5][6];
        for (int i=0;i<5;i++){
            for (int j=0;j<6;j++){
                firstClass[i][j]=new Seat(i*10+j,2,true,i,j);
            }
        }
    }
    public int getNumberOfAvailableSeat(int classType){
        return this.numberOfAvailableSeat[classType];
    }



    @Override
    public boolean equals(Object object){
        Flight flight = (Flight)object;
        if(this.departureAirport.equals(flight.departureAirport) && this.arrivalAirport.equals(flight.arrivalAirport)&&  !this.departureDate.isAfter(flight.departureDate)) {
            return true;
        }
        else {
            return false;
        }

    }


    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
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

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirportCity) {
        this.departureAirport.setAirportCity(departureAirportCity);
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirportCity) {
        this.arrivalAirport.setAirportCity(arrivalAirportCity);
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

    public void setNumberOfAvailableSeat(int seatClass, int numberOfSeats) {
        numberOfAvailableSeat[seatClass] = numberOfAvailableSeat[seatClass] - numberOfSeats;
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

    @Override
    public int compareTo(Object obj) {
        Flight otherFlight=(Flight)obj;

        return this.departureDate.compareTo(otherFlight.departureDate);
    }
    @Override
    public int compare(Object o1, Object o2) {
        Flight f1=(Flight) o1;
        Flight f2=(Flight) o2;
        return f1.departureDate.compareTo(f2.departureDate);
    }
}