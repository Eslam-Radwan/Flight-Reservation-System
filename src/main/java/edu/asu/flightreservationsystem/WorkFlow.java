package edu.asu.flightreservationsystem;

import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class WorkFlow implements Serializable,UploadData, LoadData{
    public static ArrayList<Flight> Flights = new ArrayList<>();
    public static ArrayList<ApplicationUser> appUsers = new ArrayList<>();
    public static ArrayList<Airport> airports = new ArrayList<>();


    public void work(Stage priamryStage)
    {
        loadData();
        priamryStage.setOnCloseRequest(e -> uploadData());

        makeLocalAdmin();


        LoginPage login = new LoginPage();
        login.loginPage(priamryStage);


    }
    private void makeLocalAdmin(){
        boolean thereIsAdmin = false;
        for(ApplicationUser appUser:appUsers){
            if(appUser instanceof Admin){
                thereIsAdmin = true;
            }
        }
        if(thereIsAdmin == false) {
            Admin admin = new Admin();
            admin.setFirstName("Ahmed");
            admin.setLastName("Mohamed");
            admin.setPassword("123");
            admin.setUsername("admin");
            admin.setEmailAddress("admin@gmail.com");
            appUsers.add(admin);
        }
    }





}
