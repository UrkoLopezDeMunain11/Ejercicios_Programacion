package Vista;

import Controladores.*;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import java.util.List;
import java.util.Scanner;

public class MenuTitulares
{


        private Scanner sc;

        private TitularController titularController;

        public MenuTitulares()
        {
            sc = new Scanner(System.in);

            titularController = new TitularController();
        }




        public void mostrarMenu()
        {
            int opcion;
            do
            {
                System.out.println("\n====== MENÚ BANCO (TITULARES)  ======");
                System.out.println("1. Crear titular");
                System.out.println("2. Modificar titular");
                System.out.println("3. Borrar titular");
                System.out.println("4. Listar titulares");
                System.out.println("5. Listar titulares por nombre");
                System.out.println("6. Buscar por ID");
                System.out.println("7. Buscar por DNI");
                System.out.println("0. Salir");
                System.out.println("========================");

                opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

                switch (opcion) {
                    case 1 -> crearTitular();
                    case 2 -> modificarTitular();
                    case 3 -> borrarTitular();
                    case 4 -> listarTitulares();
                    case 5 -> listarPorNombre();
                    case 6 -> buscarPorId();
                    case 7 -> buscarPorDni();


                    case 0 -> System.out.println("Saliendo del programa");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 0);
        }

        private void crearTitular()
        {
            System.out.println("\n--- CREAR TITULAR ---");
            try
            {
                String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
                if (dni != null) {
                    String nombre = EntradaDatos.leerTexto(sc, "Introduce nombre: ", "^[A-Za-z ]+$");
                    if (nombre != null) {
                        titularController.crearTitular(dni, nombre);
                        System.out.println("Titular creado correctamente.");
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Problemas creando el titular");
            }

        }


        private void borrarTitular() {
            System.out.println("\n--- BORRAR TITULAR ---");
            try
            {
                int id = EntradaDatos.leerEntero(sc, "Introduce id del titular a borrar: ");
                if (id != -1)
                {
                    int n= titularController.borrarTitular(id);
                    if (n==1)
                    {
                        System.out.println("Titular borrado correctamente.");
                    }
                    else {
                        System.out.println("No se encontró ningún titular con el ID proporcionado.");
                    }

                }

            }
            catch (Exception e)
            {
                System.out.println("Problemas borrando el titular");
            }
        }

        private Titular buscarPorDni() {
            System.out.println("\n--- BUSCAR TITULAR POR DNI ---");
            String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
            if (dni != null) {
                Titular titular = titularController.buscarPorDni(dni);
                if (titular != null) {
                    System.out.println("Titular encontrado: " + titular);
                } else {
                    System.out.println("No se encontró ningún titular con el DNI proporcionado.");
                }
                return titular;
            }
            return null;
        }

        private void listarPorNombre() {
        System.out.println("\n--- BUSCAR TITULAR POR NOMBRE ---");
        String nombre = EntradaDatos.leerTexto(sc, "Introduce nombre: ", "^[A-Za-z ]+$");
        if (nombre != null) {
            // Variable global?
            StringBuilder sb= titularController.buscarPorNombre(nombre);
            if (!sb.isEmpty()) {
                System.out.println(sb.toString());
            } else {
                System.out.println("No se encontró ningún titular con el nombre proporcionado.");
            }
        }
    }

        private Titular buscarPorId() {
            System.out.println("\n--- BUSCAR TITULAR POR ID ---");
            int id = EntradaDatos.leerEntero(sc, "Introduce ID: ");
            if (id != -1) {
                // Si es -1, ya hemos mostrado un mensaje de error en la función leerEntero, así que no hace falta mostrar otro aquí.
                // Variable global?
                Titular titular = titularController.buscarPorId(id);
                if (titular != null) {
                    System.out.println("Titular encontrado: " + titular);
                } else {
                    System.out.println("No se encontró ningún titular con el ID proporcionado.");
                }
                return titular;
            }
            return null;
        }


        private void modificarTitular() {
            System.out.println("\n--- MODIFICAR TITULAR ---");
            Titular titular = buscarPorDni();
            if (titular != null) {
                String nuevoNombre = EntradaDatos.leerTexto(sc, "Introduce nuevo nombre: ", "^[A-Za-z ]+$");
                if (nuevoNombre != null) {
                    titularController.modificarTitular(titular, nuevoNombre);
                    System.out.println("Titular modificado correctamente.");
                }
            }
        }

        private void listarTitulares() {
            System.out.println("\n--- LISTADO DE TITULARES ---");
            List<Titular> titulares = titularController.listarTitulares();

            if (titulares.isEmpty())
            {
                System.out.println("No hay titulares registrados.");
            } else
            {
                for (Titular t : titulares) {
                    System.out.println(t);
                }
            }
        }



    }

