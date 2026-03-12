package Controladores;

import DAO.CuentaDAO;
import Modelo.Cuenta;

import java.util.List;

public class CuentaController {

    private static CuentaDAO cuentaDAO;

    public CuentaController() {
        cuentaDAO = new CuentaDAO();
    }
    public static List<Cuenta> listarCuentas() {
        return cuentaDAO.listarCuentas();
    }

    public static void borrarCuenta(String numeroCuenta) {
        CuentaDAO.borrarCuenta(numeroCuenta);
    }

    public static void modificarCuenta(Cuenta cuenta, String nuevoNumeroCuenta) {
        cuenta.setNumeroCuenta(nuevoNumeroCuenta);
        cuentaDAO.modificarCuenta(cuenta);

    }

    public static void crearCuenta(String numeroCuenta, double saldoInicial) {
        Cuenta cuenta = new Cuenta(0, numeroCuenta, saldoInicial, 0);
        CuentaDAO.crearCuenta(cuenta);
    }
}
