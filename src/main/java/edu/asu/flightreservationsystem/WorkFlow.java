package edu.asu.flightreservationsystem;

import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class WorkFlow implements Serializable{
    public static ArrayList<Flight> Flights = new ArrayList<>();
    public static ArrayList<ApplicationUser> appUsers = new ArrayList<>();

    public void work(Stage priamryStage)
    {

        Admin localAdmin = makeLocalAdmin();
        appUsers.add(localAdmin);


        LoginPage login = new LoginPage();
        login.loginPage(priamryStage);


    }
    private Admin makeLocalAdmin(){
        Admin admin = new Admin();
        admin.setFirstName("Ahmed");
        admin.setLastName("Mohamed");
        admin.setPassword("123");
        admin.setUsername("admin");
        admin.setEmailAddress("admin@gmail.com");
        return admin;
    }





}
