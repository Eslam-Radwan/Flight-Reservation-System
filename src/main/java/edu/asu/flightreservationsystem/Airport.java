package edu.asu.flightreservationsystem;


import java.io.Serializable;

public class Airport implements Serializable {
    private int airportCode;
    private String airportName;
    private String airportLocation;
//   private Flight [] flightsInfo ;

    public void setAirportCode(int airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public int getAirportCode() {
        return airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

//     public void setFlightsInfo(Flight[] flightsInfo)
//     {
//        this.flightsInfo = flightsInfo;
//        //comment
//
//     }
}
