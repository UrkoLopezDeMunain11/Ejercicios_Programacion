package Vista;

import Controlador.PasajeroController;
import Modelo.Pasajero;
import Modelo.Vuelo;
import Utilidades.EntradaDatos;

import java.util.List;
import java.util.Scanner;

public class MenuPasajero {
    static Scanner sc = new Scanner(System.in);

    public void MostrarMenu() {
        int opcion = 0;
        do {
            try {
                System.out.println("========MENU PASAJERO=========");
                System.out.println("1. ALTA");
                System.out.println("2. BAJA");
                System.out.println("3. MODIFICAR");
                System.out.println("4. Datos pasajero a traves del DNI");
                System.out.println("5. Salir del programa");
                System.out.println("6. Volver al menu principal");
                System.out.println("=============================");

                System.out.println("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        altaPasajero();
                        break;
                    case 2:
                        bajaPasajero();
                        break;
                    case 3:
                        modificarPasajero();
                        break;
                    case 4:
                        datosPasajeroDNI();
                        break;
                    case 5:
                        mostrarPasajerosVuelo();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    case 7:// para volver al menu principal al de antes del cual he venido a este
                        System.out.println("Volviendo al menú principal...");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.nextLine();
            }


        } while (opcion != 6);
    }

    private void altaPasajero() {
        System.out.println("\n--- CREAR PASAJERO ---");
        String dni = EntradaDatos.pedirDniValido();
        System.out.println("Ingrese el nombre del pasajero:");
        String nombre = sc.next();
        System.out.println("Ingrese el apellido del pasajero:");
        String telefono = sc.next();
        boolean codigoValido = false;
        String cod_vuelo;
        do {
            System.out.println("Ingrese el codigo del vuelo:");
            cod_vuelo = sc.next();
            try {
                Vuelo.setCod_vuelo(cod_vuelo);
                codigoValido = true;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, inténtalo de nuevo");

            }
        } while (!codigoValido);

        if (codigoValido) {
            PasajeroController.altaPasajero(dni, nombre, telefono, cod_vuelo);
        }

    }

    private void bajaPasajero() {
        System.out.println("\n--- ELIMINAR PASAJERO ---");
        String dni = EntradaDatos.pedirDniValido();
        PasajeroController.bajaPasajero(dni);
    }

    private void modificarPasajero() {
        System.out.println("\n--- MODIFICAR PASAJERO ---");
        System.out.println("Ingrese el DNI del pasajero:");
        String dni = sc.next();
        if (dni != null || !dni.isEmpty()) {
            System.out.println("Ingrese el nuevo nombre del pasajero:");
            String nuevoNombre = sc.next();
            System.out.println("Ingrese el nuevo telefono del pasajero:");
            String nuevoTelefono = sc.next();
            boolean codigoValido = false;
            String NuevoCod_vuelo;
            do {
                System.out.println("Ingrese el nuevo codigo del vuelo:");
                NuevoCod_vuelo = sc.next();
                try {
                    Vuelo.setCod_vuelo(NuevoCod_vuelo);
                    codigoValido = true;

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Por favor, inténtalo de nuevo");

                }
            } while (!codigoValido);

            if (codigoValido) {
                PasajeroController.modificarPasajero(dni, nuevoNombre, nuevoTelefono, NuevoCod_vuelo);
            }
        }

    }

    private Pasajero datosPasajeroDNI() {
        System.out.println("\n--- DATOS PASAJERO POR DNI ---");
        String dni = EntradaDatos.pedirDniValido();
        Pasajero pasajero = PasajeroController.datosPasajeroDNI(dni);
        if (pasajero != null) {
            System.out.println("Paqsajero encontrado con ese dni:" + pasajero);
        } else {
            System.out.println("No se encontró ningún pasajero con ese DNI.");
        }
        return null;

    }

    private void mostrarPasajerosVuelo() {
        System.out.println("\n--- PASAJEROS DE UN VUELO ---");
        System.out.println("Ingrese el código del vuelo:");
        String cod_vuelo = sc.next();

        List<Pasajero> pasajeros = PasajeroController.mostrarPasajerosPorVuelo(cod_vuelo);

        if (pasajeros.isEmpty()) {
            System.out.println("No hay.");
        } else {
            for (Pasajero p : pasajeros) {
                System.out.println(p);
            }
        }
    }
}
