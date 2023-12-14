package edu.asu.flightreservationsystem;

public class AdminData {
    private static final AdminData instance = new AdminData();
    private Admin admin;


    public static AdminData getInstance() {return instance;}

    public Admin getAdmin() {return admin;}

    public void setAdmin(Admin Admin) {
        this.admin = Admin;
    }
}
