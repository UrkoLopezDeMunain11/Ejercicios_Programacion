package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;

import java.time.LocalDate;

public class PersonaController {


    public static void insertarPersona(String nombre, String apellido, String dni, String telefono, LocalDate fechaNacimiento, int edad) {
        Persona p = new Persona(nombre, apellido,dni, telefono, fechaNacimiento, edad);
        PersonaDAO.insertarPersona(p);

    }

    public static void ActualizarPersona(String nombre, String apellido, String dni, String telefono, LocalDate fechaNacimiento, int edad) {
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDNI(dni);
        p.setTelefono(telefono);
        p.setFecha_nacimiento(fechaNacimiento);
        p.setEdad(edad);
        PersonaDAO.actualizarPersona(p);
    }

    public static boolean eliminarPersona(String dni) {
        return PersonaDAO.eliminarPersona(dni);

    }
}
