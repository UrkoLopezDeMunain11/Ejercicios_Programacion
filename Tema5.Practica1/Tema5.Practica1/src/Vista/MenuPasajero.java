package Vista;

import Controlador.PasajeroController;

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
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    case 6:// para volver al menu principal al de antes del cual he venido a este
                        System.out.println("Volviendo al menú principal...");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                }
            }catch (NumberFormatException e){
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.nextLine();
            }


        } while (opcion != 5);
    }

    private void altaPasajero() {
        System.out.println("\n--- CREAR PASAJERO ---");
        System.out.println("Ingrese el DNI del pasajero:");
        String dni = sc.next();
        System.out.println("Ingrese el nombre del pasajero:");
        String nombre = sc.next();
        System.out.println("Ingrese el apellido del pasajero:");
        String telefono = sc.next();
        System.out.println("Ingrese la edad del pasajero:");
        String cod_vuelo = sc.next();
        PasajeroController.altaPasajero(dni, nombre, telefono, cod_vuelo);

    }

    private void bajaPasajero() {
        System.out.println("\n--- ELIMINAR PASAJERO ---");
        System.out.println("Ingrese el DNI del pasajero:");
        String dni = sc.next();
        PasajeroController.bajaPasajero(dni);
    }

    private void modificarPasajero() {
        System.out.println("\n--- MODIFICAR PASAJERO ---");
        System.out.println("Ingrese el DNI del pasajero:");
        String dni = sc.next();
        if(dni != null || !dni.isEmpty()){
            System.out.println("Ingrese el nuevo nombre del pasajero:");
            String nuevoNombre = sc.next();
            System.out.println("Ingrese el nuevo telefono del pasajero:");
            String nuevoTelefono = sc.next();
            System.out.println("Ingrese el nuevo codigo de vuelo del pasajero:");
            String nuevoCodVuelo = sc.next();
            PasajeroController.modificarPasajero(dni, nuevoNombre, nuevoTelefono, nuevoCodVuelo);
        }

    }

    private void datosPasajeroDNI() {
    }
}
