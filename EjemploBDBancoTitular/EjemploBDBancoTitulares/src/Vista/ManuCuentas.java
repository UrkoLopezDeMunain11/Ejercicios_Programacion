package Vista;

import Controladores.CuentaController;
import Controladores.TitularController;
import DAO.CuentaDAO;
import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManuCuentas {
        private Scanner sc;


    public void mostrarMenu()
    {
        int opcion;
        do
        {
            System.out.println("\n====== MENÚ BANCO (TITULARES)  ======");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Modificar cuenta");
            System.out.println("3. Borrar cuenta");
            System.out.println("4. Listar cunetas");
            System.out.println("5. Listar titulares por nombre");
            System.out.println("6. Buscar por ID");
            System.out.println("7. Buscar por DNI");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearCuenta();
                case 2 -> modificarCuenta();
                case 3 -> borrarCuenta();
                case 4 -> listarCuenta();
                case 0 -> System.out.println("Saliendo del programa");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }



    private void crearCuenta() {
        System.out.println("\n--- CREAR CUENTA ---");
        String numeroCuenta = EntradaDatos.leerTexto(sc, "Introduce el número de cuenta: ", "\\d{20}");
        double saldoInicial = EntradaDatos.leerEntero(sc, "Introduce el saldo inicial:");

        CuentaController.crearCuenta(numeroCuenta, saldoInicial);

    }

    private void modificarCuenta() {
        System.out.println("\n--- MODIFICAR TITULAR ---");
        Cuenta cuenta = buscarPorDni();
        if (cuenta != null) {
            String nuevoNombre = EntradaDatos.leerTexto(sc, "Introduce nuevo nombre: ", "^[A-Za-z ]+$");
            if (nuevoNombre != null) {
                CuentaController.modificarCuenta(cuenta, nuevoNombre);
                System.out.println("Titular modificado correctamente.");
            }
        }
    }

    private Cuenta buscarPorDni() {
    }

    private void borrarCuenta() {
        System.out.println("\n--- BORRAR CUENTA ---");
        String numeroCuenta = EntradaDatos.leerTexto(sc, "Introduce el número de cuenta a eliminar: ", "\\d{20}");
        if (numeroCuenta != null) {
            CuentaController.borrarCuenta(numeroCuenta);
        }

    }

    private void listarCuenta() {
        System.out.println("\n--- LISTAR CUENTAS ---");
        List<Cuenta>cuentas = new ArrayList<>();

        if(cuentas.isEmpty()){
            System.out.println("No hay cuentas registradas.");
        }else{
            for (Cuenta cuenta : cuentas) {
                System.out.println(cuenta);
                CuentaController.listarCuentas();
            }
        }

    }



}
