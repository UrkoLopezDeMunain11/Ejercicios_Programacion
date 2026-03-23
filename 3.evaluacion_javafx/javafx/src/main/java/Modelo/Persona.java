package Modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Persona {
    private String DNI;
    private String Nombre;
    private String Apellido;
    private LocalDate fecha_nacimiento;
    private int edad;
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String dni, String telefono, LocalDate fechaNacimiento, int edad) {
        this.DNI = DNI;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.telefono = telefono;
    }


    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
