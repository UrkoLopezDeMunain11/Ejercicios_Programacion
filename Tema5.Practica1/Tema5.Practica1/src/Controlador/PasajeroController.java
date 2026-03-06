package Controlador;

import DAO.PasajeroDAO;
import Modelo.Pasajero;

import java.util.List;

public class PasajeroController {

    public static void altaPasajero(String dni, String nombre, String telefono, String cod_vuelo) {
        Pasajero pasajero = new Pasajero(dni, nombre, telefono, cod_vuelo);
        PasajeroDAO.insertarPasajero(pasajero);

    }

    public static void bajaPasajero(String dni) {
        PasajeroDAO.borrarPasajero(dni);
    }

    public static void modificarPasajero(String dni, String nuevoNombre, String nuevoTelefono, String nuevoCodVuelo) {
        Pasajero.setDni(dni);
        Pasajero.setNombre(nuevoNombre);
        Pasajero.setTelefono(nuevoTelefono);
        Pasajero.setCod_vuelo(nuevoCodVuelo);
        PasajeroDAO.modificarPasajero(dni, nuevoNombre, nuevoTelefono, nuevoCodVuelo);
    }

    public static Pasajero datosPasajeroDNI(String dni) {
        return PasajeroDAO.obtenerPasajeroPorDNI(dni);
    }

    public static List<Pasajero> mostrarPasajerosPorVuelo(String cod_vuelo) {
        return PasajeroDAO.obtenerPasajerosPorVuelo(cod_vuelo);
    }
}
