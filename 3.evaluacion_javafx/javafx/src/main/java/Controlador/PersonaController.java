package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;

import java.time.LocalDate;

public class PersonaController {


    public static void insertarPersona(String nombre, String apellido, String dni, String telefono, LocalDate fechaNacimiento, int edad) {
        Persona p = new Persona(nombre, apellido,dni, telefono, fechaNacimiento, edad);
        PersonaDAO.insertarPersona(p);

    }
}
