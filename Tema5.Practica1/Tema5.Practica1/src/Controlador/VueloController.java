package Controlador;

import DAO.VueloDAO;
import Modelo.Vuelo;

import java.util.Date;

public class VueloController {
    public static void agregarVuelo(String codigo, String destino, Date fecha, String procedencia) {
        Vuelo vuelo = new Vuelo(codigo, fecha, destino, procedencia, null);
        VueloDAO.insertarVuelo(vuelo);
    }

    public static void eliminarVuelo(String codVuelo) {
        VueloDAO.eliminarVuelo(codVuelo);
    }

    public static void modificarVuelo(String codVuelo, String nuevoDestino, Date nuevaFecha, String nuevaProcedencia) {
        Vuelo.setCod_vuelo(codVuelo);
        Vuelo.setDestino(nuevoDestino);
        Vuelo.setFecha_salida(nuevaFecha);
        Vuelo.setProcedencia(nuevaProcedencia);
        VueloDAO.modificarVuelo(codVuelo, nuevoDestino, nuevaFecha, nuevaProcedencia);
    }
}
