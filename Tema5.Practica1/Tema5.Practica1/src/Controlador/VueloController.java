package Controlador;

import DAO.VueloDAO;
import Modelo.Vuelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class VueloController {
    private static VueloDAO vueloDAO;

    public VueloController(){
        vueloDAO = new VueloDAO();
    }


    public static void agregarVuelo(String codigo, String destino, Date fecha, String procedencia) {
        Vuelo vuelo = new Vuelo(codigo, fecha, destino, procedencia, null);
        vueloDAO.insertarVuelo(vuelo);
    }

    public static String eliminarVuelo(String codVuelo) {
        return vueloDAO.eliminarVuelo(codVuelo);
    }

    public static void modificarVuelo(String codVuelo, String nuevoDestino, Date nuevaFecha, String nuevaProcedencia) {
        Vuelo.setCod_vuelo(codVuelo);
        Vuelo.setDestino(nuevoDestino);
        Vuelo.setFecha_salida(nuevaFecha);
        Vuelo.setProcedencia(nuevaProcedencia);
        vueloDAO.modificarVuelo(codVuelo, nuevoDestino, nuevaFecha, nuevaProcedencia);
    }

    public static Vuelo mostrarVuelosDestino(String destino) {
        return VueloDAO.obtenerVuelosPorDestino(destino);
    }

    public static List<Vuelo> mostrarVuelosFecha(LocalDate fecha) {
        return vueloDAO.obtenerVuelosPorFecha(fecha);
    }

    public static List<Vuelo> mostrarVuelosOrigen(String origen) {
        return vueloDAO.obtenerVuelosPorOrigen(origen);
    }
}
