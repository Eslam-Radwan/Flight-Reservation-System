package edu.asu.flightreservationsystem;

import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class WorkFlow implements UserWork, AdminWork, LoginMenu, SignupMenu, LoadData, UploadData,Serializable{
    public static ArrayList<Flight> Flights = new ArrayList<>();
    public static ArrayList<ApplicationUser> appUsers = new ArrayList<>();
    public void preWork(Stage priamryStage){
        loadData();
        Admin localAdmin = makeLocalAdmin();
        appUsers.add(localAdmin);
        User localUser = makeLocalUser();
        appUsers.add(localUser);

        /*
        boolean doWork;
        do {
            doWork = work();
        }while(doWork);
        uploadData();

         */
    }
    public boolean work(Stage priamryStage)
    {

//        Admin localAdmin = makeLocalAdmin();
//        appUsers.add(localAdmin);
//        User localUser = makeLocalUser();
//        appUsers.add(localUser);



//        int firstPageCheck;
//        do {
//            firstPageCheck = firstPage();// 1 for login, 2 for signup
//            if (firstPageCheck == 2) {
//                ApplicationUser user = new User();
//                signupMenu(user);
//                appUsers.add(user);
//                continue;
//            }
//        }while(firstPageCheck == 2);

        LoginPage login = new LoginPage();
        login.loginPage(priamryStage,appUsers);

/*
        ApplicationUser appUser = loginMenu(appUsers);
        if(appUser instanceof User){
            User user = (User)appUser;
            int gotToWork = userWork(user); //0 -> the program upload the data and exit, 1 -> logout
            while(gotToWork == 2){
                gotToWork = userWork(user);
            }
            if(gotToWork == 0){
                return false;
            }
            else {
                return true;
            }
        }
        else if(appUser instanceof Admin){
            Admin admin = (Admin)appUser;
            int gotToWork = adminWork(admin); //0 -> the program upload the data and exit, 1 -> logout
            while(gotToWork == 2) {
                gotToWork = adminWork(admin);
            }
            if(gotToWork == 0){
                return false;
            }
            else {
                return true;
            }
        }
        */

        return false;


    }


    private int firstPage(){
        System.out.println("[1]Login");
        System.out.println("[2]Signup");
        System.out.print("Go To: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        return choice;
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

    private User makeLocalUser(){
        User user = new User();
        user.setFirstName("Mostafa");
        user.setLastName("Ali");
        user.setPassword("123");
        user.setUsername("user");
        user.setEmailAddress("user@gmail.com");
        return user;
    }



}
