package org.example.demofx.controlador.modelo;

import org.example.demofx.modelo.Persona;
import org.example.demofx.modelo.PersonaDAO;

import java.time.LocalDate;

public class PersonaController {
    private static PersonaDAO personaDAO = new PersonaDAO();

    public static void insertarPersona(String nombre,String apellidos,String dni, String telefono,LocalDate fechaNacimiento, int edad) {
        Persona persona = new Persona(nombre, apellidos, dni, telefono, fechaNacimiento, edad);
        personaDAO.insertar(persona);
    }
}
