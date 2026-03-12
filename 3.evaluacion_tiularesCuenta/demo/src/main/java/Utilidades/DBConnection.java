package Utilidades;

import jakarta.persistence.EntityManagerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEMF() {
        return emf;
    }

    public static void crearEMF(){
        emf = jakarta.persistence.Persistence.createEntityManagerFactory("appTitulares");
    }
}

