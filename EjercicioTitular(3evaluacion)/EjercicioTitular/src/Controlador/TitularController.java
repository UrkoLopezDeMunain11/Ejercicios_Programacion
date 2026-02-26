package Controlador;

import Modelo.Titular;
import Modelo.TitularDAO;

public class TitularController {
    public static void creartitular(String dni, String nombre) {
        // crear el objeto
        Titular titular = new Titular(0, nombre, dni); // el id 0 porque es autoincremental y se asigna automaticamente
        // llamar al dao para q haga el insert con los datos q le he pasado
        TitularDAO.insertarTitular(titular);
    }

    public static void eliminarTitular(String dni) {
        TitularDAO.eliminar(dni);
    }

    public static void modificarTitular(Titular titular, String dni, String nombre, String nombreNuevo) {
        titular.setNombre(nombreNuevo);
        TitularDAO.actualizarTitular(titular);
    }

    public static Titular buscar(String dni) {
        return TitularDAO.buscar(dni);
    }
/*
    public static void listaTitulares() {
        TitularDAO.listarTitulares();
    }

 */
}
