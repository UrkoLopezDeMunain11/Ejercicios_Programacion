import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Set<String>Portero = new HashSet<>();
    static Set<String>Defensa = new HashSet<>();
    static Set<String>Centrocampista = new HashSet<>();
    static Set<String>Delantero = new HashSet<>();



    public static void main(String[] args) {
        enum Posicion {Portero, Defensa, Centrocampista, Delantero}
        insertarNombres();
        altas();
        bajas();
        modificar();
    }

    private static void insertarNombres() {
        String respuesta;
        do {
            boolean nombreValido = false;
            String nombre;
            do {
                System.out.println("Introduce el nombre del jugador: ");
                nombre = sc.nextLine();
                Pattern pt = Pattern.compile("^[A-Za-z]*$");
                Matcher mat = pt.matcher(nombre);
                if (mat.matches()) {
                    System.out.println("Nombre introducido correctamente");
                    nombreValido = true;
                } else {
                    System.out.println("Nombre introducido incorrectamente");
                    nombreValido = false;
                }
            } while (!nombreValido);

            int rol = 0;
            do {
                try {
                    System.out.println("-------------Elige el rol del jugador------------- ");
                    System.out.println("1- Portero");
                    System.out.println("2- Defensa");
                    System.out.println("3- Centrocampista");
                    System.out.println("4- Delantero");
                    System.out.println("5- Salir");

                    rol = sc.nextInt();
                    sc.nextLine();
                    switch (rol) {
                        case 1:
                            Portero.add(nombre);
                            break;
                        case 2:
                            Defensa.add(nombre);
                            break;
                        case 3:
                            Centrocampista.add(nombre);
                            break;
                        case 4:
                            Delantero.add(nombre);
                            break;
                        case 5:
                            System.out.println("Saliendo");
                            break;
                        default:
                            System.out.println("Rol insertado incorrecto");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("El rol insertado incorrecto");
                    sc.nextLine();
                }
            } while (rol != 5);

            boolean respuestaValido = false;
            do {
                System.out.println("Desea añadir algun jugador mas?(SI/NO)");
                respuesta = sc.nextLine();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("Respuesta incorrecta");
                    respuestaValido = false;
                } else {
                    respuestaValido = true;
                }
            } while (!respuestaValido);

        } while (respuesta.equalsIgnoreCase("SI"));

        System.out.println("-----------------Jugadores que hay disponibles en el mercado de invierno------------------");
        System.out.println("Porteros: " + Portero);
        System.out.println("Defensas: " + Defensa);
        System.out.println("Centrocampistas: " + Centrocampista);
        System.out.println("Delanteros: " + Delantero);
    }

    private static void altas() {
        System.out.println("Añade mas jugadores(alta): ");
        String nombre = sc.nextLine();

        int rol = 0;
        do {
            try {
                System.out.println("-------------Elige el rol del jugador------------- ");
                System.out.println("1- Portero");
                System.out.println("2- Defensa");
                System.out.println("3- Centrocampista");
                System.out.println("4- Delantero");
                System.out.println("5- Salir");

                rol = sc.nextInt();
                sc.nextLine();
                switch (rol) {
                    case 1:
                        Portero.add(nombre);
                        break;
                    case 2:
                        Defensa.add(nombre);
                        break;
                    case 3:
                        Centrocampista.add(nombre);
                        break;
                    case 4:
                        Delantero.add(nombre);
                        break;
                    case 5:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Rol insertado incorrecto");
                }
            } catch (InputMismatchException e) {
                System.out.println("El rol insertado incorrecto");
                sc.nextLine();
            }
        } while (rol != 5);
    }


    private static void bajas() {
        String respuesta;
        do {
            System.out.println("Jugador q quieres eliminar: ");
            String nombre = sc.nextLine();

            if (Portero.contains(nombre)) {
                Portero.remove(nombre);
                System.out.println("Jugador eliminado");
            }
            if (Defensa.contains(nombre)) {
                Defensa.remove(nombre);
                System.out.println("Jugador eliminado");
            }
            if (Centrocampista.contains(nombre)) {
                Centrocampista.remove(nombre);
                System.out.println("Jugador eliminado");
            }
            if (Delantero.contains(nombre)) {
                Delantero.remove(nombre);
                System.out.println("Jugador eliminado");
            }

            boolean respuestaValida = false;
            do {
                System.out.println("Quieres dar de baja mas jugadpres? (SI/NO)");
                respuesta = sc.nextLine();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("Respuesta incorrecta");
                } else {
                    System.out.println("Respuesta correcta");
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));

        System.out.println("------------------Lista Jugadores-------------------");
        System.out.println("Porteros: " + Portero);
        System.out.println("Defensas: " + Defensa);
        System.out.println("Centrocampistas: " + Centrocampista);
        System.out.println("Delanteros: " + Delantero);
    }

    private static void modificar() {
        String respuesta = "";
        boolean encontrado = false;

            do {
                System.out.print("Introduce el nombre del jugador a modificar: ");
                String nombre = sc.nextLine();

                if (Portero.contains(nombre)) {
                    Portero.remove(nombre);
                    System.out.println("Inserte jugador modificado");
                    String jugadorModi = sc.nextLine();
                    Portero.add(nombre);
                    encontrado = true;
                }
                if (Defensa.contains(nombre)) {
                    Defensa.remove(nombre);
                    System.out.println("Inserte jugador modificado");
                    String jugadorModi = sc.nextLine();
                    Defensa.add(nombre);
                    encontrado = true;
                }
                if (Centrocampista.contains(nombre)) {
                    Centrocampista.remove(nombre);
                    System.out.println("Inserte jugador modificado");
                    String jugadorModi = sc.nextLine();
                    Centrocampista.add(nombre);
                    encontrado = true;
                }
                if (Delantero.contains(nombre)) {
                    Delantero.remove(nombre);
                    System.out.println("Inserte jugador modificado");
                    String jugadorModi = sc.nextLine();
                    Delantero.add(nombre);
                    encontrado = true;
                }
                if (!encontrado) {
                    System.out.println("Nombre no encontrado en ningun sitio, vuelve a introducirlo");
                    encontrado = false;
                }
            }while (!encontrado);



    }
}