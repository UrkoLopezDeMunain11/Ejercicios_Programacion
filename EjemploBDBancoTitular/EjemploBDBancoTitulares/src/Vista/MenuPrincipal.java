package Vista;

import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuPrincipal {
    public void mostrarMenu() {
        int opcion;
        do {

            System.out.println("\n====== MENÚ PRINCIPAL  ======");
            System.out.println("1. Gestionar Titulares");
            System.out.println("2. Gestionar Cuentas");
            System.out.println("3. Salir");
            System.out.println("========================");


            opcion = EntradaDatos.leerEntero(new Scanner(System.in), "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    MenuTitulares menuTitulares = new MenuTitulares();
                    menuTitulares.mostrarMenu();
                    break;
                case 2:
                    ManuCuentas manuCuentas = new ManuCuentas();
                    manuCuentas.mostrarMenu();
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        } while (opcion != 3);
    }
}
