package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;

public class Admin extends Persona{
    private Admin() {

    }
    public static Admin getAdmin(){
        Admin admin = new Admin();
        admin.setNome("Victor");
        admin.setCognome("Conde");
        admin.setCF("FFFFFFFFFFF");
        admin.setEmail("Victor.Conde@gmail.com");
        admin.setPassword("$2a$10$Di1m4ekm5aWzD6xpecaCveLJ2Pf5ASVEn8.HzNPLEtkK4L5JYxvsy");
        return admin;
    }
    private static final String Password = "VictorConde5678%/";
}
