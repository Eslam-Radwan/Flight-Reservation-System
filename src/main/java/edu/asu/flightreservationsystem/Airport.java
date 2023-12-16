package edu.asu.flightreservationsystem;


import java.io.Serializable;

public class Airport implements Serializable {
    private String airportCode;//CAI
    private String airportCountry;//egypt
    private String airportCity;//cairo


    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public String getAirportCity() {
        return airportCity;
    }

    @Override
    public String toString() {    //Cairo, Egypt (CAI)
        return airportCity + ", " + airportCountry + " (" + airportCode + ')';
    }
}
