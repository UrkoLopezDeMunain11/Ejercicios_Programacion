package Vista;

import Controlador.VueloController;
import Modelo.Vuelo;

import java.util.Date;
import java.util.Scanner;

public class MenuVuelo {
    static Scanner sc = new Scanner(System.in);
    public void MostrarMenu() {
        int opcion = 0;
        do {
            try {
                System.out.println("================MENU VUELO================");
                System.out.println("1. Agregar Vuelo");
                System.out.println("2. Eliminar Vuelo");
                System.out.println("3. Modificar Vuelo");
                System.out.println("4. datos de vuelo a traves del codigo ");
                System.out.println("5. Mostrar velos a un destino concreto");
                System.out.println("6. Vuelos por origen");
                System.out.println("7. Lista vuelos para una fecha concreta");
                System.out.println("8. Salir del programa");
                System.out.println("9. Volver al menu principal");
                System.out.println("=========================================");

                System.out.println("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        agregarVuelo();
                        break;
                    case 2:
                        eliminarVuelo();
                        break;
                    case 3:
                        modificarVuelo();
                        break;
                    case 4:
                        mostrarVuelosDestino();
                        break;
                    case 5:
                        mostrarVuelosOrigen();
                        break;
                    case 6:
                        mostrarVuelosFecha();
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    case 8:
                        System.out.println("Volviendo al menú principal...");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.nextLine();
            }
        } while (opcion != 7);
    }

    private void agregarVuelo() {
        System.out.println("\n--- AGREGAR VUELO ---");
        boolean codigoValido = false;
        String cod_vuelo = null;

        do{
            System.out.println("Ingrese el codigo del vuelo:");
            cod_vuelo = sc.next();

            try{
                Vuelo.setCod_vuelo(cod_vuelo);
                codigoValido = true;

            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, inténtalo de nuevo");

            }

        }while (!codigoValido);

        if(codigoValido) {
            System.out.println("Ingrese el destino del vuelo:");
            String destino = sc.next();
            System.out.println("Ingrese la fecha del vuelo (formato: dd/MM/yyyy):");
            Date fecha = new Date();
            System.out.println("Ingrese la procedencia del vuelo:");
            String procedencia = sc.next();
            VueloController.agregarVuelo(cod_vuelo, destino, fecha, procedencia);
        }
    }

    private void eliminarVuelo() {
        System.out.println("\n--- ELIMINAR VUELO ---");
        boolean codigoValido = false;
        String cod_vuelo;
        do{
            System.out.println("Ingrese el codigo del vuelo:");
            cod_vuelo = sc.next();

            try{
                Vuelo.setCod_vuelo(cod_vuelo);
                codigoValido = true;

            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, inténtalo de nuevo");

            }

        }while(!codigoValido);


        if(codigoValido) {
            VueloController.eliminarVuelo(cod_vuelo);
        }
    }

    private void modificarVuelo() {
        System.out.println("\n--- MODIFICAR VUELO ---");
        boolean codigoValido = false;
        String cod_vuelo = null;
        do{
            System.out.println("Ingrese el codigo del vuelo:");
            cod_vuelo = sc.next();

            try{
                Vuelo.setCod_vuelo(cod_vuelo);
                codigoValido = true;

            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, inténtalo de nuevo");

            }

        }while(!codigoValido);

        if (codigoValido) {
            System.out.println("Ingrese el nuevo destino del vuelo:");
            String nuevoDestino = sc.next();
            System.out.println("Ingrese la nueva fecha del vuelo (formato: dd/MM/yyyy):");
            Date nuevaFecha = new Date();
            System.out.println("Ingrese la nueva procedencia del vuelo:");
            String nuevaProcedencia = sc.next();
            VueloController.modificarVuelo(cod_vuelo, nuevoDestino, nuevaFecha, nuevaProcedencia);
        }
    }

    private void mostrarVuelosDestino() {
    }

    private void mostrarVuelosOrigen() {
    }

    private void mostrarVuelosFecha() {
    }
}
