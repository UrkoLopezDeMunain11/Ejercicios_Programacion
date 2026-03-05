package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pasajero {
    private String dni;
    private String nombre;
    private String telefono;
    private String cod_vuelo;

    public Pasajero(String dni, String nombre, String telefono, String cod_vuelo) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cod_vuelo = cod_vuelo;
    }

    public String getDni() {
        return dni;
    }

    public static void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCod_vuelo() {
        return cod_vuelo;
    }

    public static void setCod_vuelo(String cod_vuelo) {
        Pattern pt = Pattern.compile("^[A-Z]{3}[0-9]-[0-9]{5}$");
        Matcher mat = pt.matcher(cod_vuelo);
        if (mat.matches()) {
            this.cod_vuelo = cod_vuelo;
        } else {
            throw new IllegalArgumentException("El código de vuelo no es válido. Debe seguir el formato AAA000-00000.");
        }
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cod_vuelo='" + cod_vuelo + '\'' +
                '}';
    }
}
