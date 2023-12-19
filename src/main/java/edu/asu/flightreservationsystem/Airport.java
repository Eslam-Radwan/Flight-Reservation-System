package edu.asu.flightreservationsystem;


import java.io.Serializable;

public class Airport implements Serializable {
    private String airportCode;
    private String airportCountry;
    private String airportCity;

    public Airport(String airportCountry, String airportCity,String airportCode) {
        this.airportCode = airportCode;
        this.airportCountry = airportCountry;
        this.airportCity = airportCity;
    }

    public Airport(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    @Override
    public String toString() {
        return airportCountry+", "+airportCity+" ("+airportCode+")\n";
    }
}
