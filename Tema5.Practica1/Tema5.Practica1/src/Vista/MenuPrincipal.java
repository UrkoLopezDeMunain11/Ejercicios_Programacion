package Vista;

import java.util.Scanner;

public class MenuPrincipal {
    static Scanner sc = new Scanner(System.in);
    public void MostrarMenu(){
        int opcion = 0;
        do{
            try {
                System.out.println("========MENU PRINCIPAL========");
                System.out.println("1. Gestionar Pasajeros");
                System.out.println("2. Gestionar Vuelos");
                System.out.println("3. Salir");
                System.out.println("=============================");

                System.out.println("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        MenuPasajero menuPasajeros = new MenuPasajero();
                        menuPasajeros.MostrarMenu();
                        break;
                    case 2:
                        MenuVuelo menuVuelos = new MenuVuelo();
                        menuVuelos.MostrarMenu();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                }
            }catch (NumberFormatException e){
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.nextLine();
            }
        }while(opcion != 3);

    }
}
