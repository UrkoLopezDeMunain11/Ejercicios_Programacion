import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String , String > map = new HashMap<>();

    public static void main(String[] args) {
        añadirContacto();
        menu();

    }

    private static void añadirContacto() {
        String respuesta;
        do {
            boolean contactoValido = false;
            do {
                System.out.println("---------------Añade un contacto--------------");

                System.out.println("* Introduce el nombre: ");
                String nombre = sc.next();
                Pattern pt = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú]*$");
                Matcher mat = pt.matcher(nombre);

                System.out.println("* Introduce su numero de telefono: ");
                String telefono = sc.next();
                Pattern pt1 = Pattern.compile("^(\\+34)?[0-9]{9}$");//(\\+34)? quier decir opcionla si lo pones bien y sino no pasa nada
                Matcher mat1 = pt1.matcher(telefono);

                if (mat.matches() && mat1.matches()) {
                    map.put(telefono, nombre);
                    System.out.println("Contacto introducido correctamente" + map);
                    contactoValido = true;
                } else {
                    System.out.println("Contacto introducido incorrecto, vuelvelo a intentar");
                    contactoValido = false;
                }
            } while (!contactoValido);

            boolean respuestaValida = false;
            do {
                System.out.println("Quieres introducir otro contacto mas?(SI/NO)");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("Respuesta incorrecta vveulvela a introducir");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));

    }
    private static void menu() {

        int opcion = 0;
        do {
            try {
                System.out.println("----------------------MENU----------------------");
                System.out.println("1- Añadir un nuevo número");
                System.out.println("2- Borrar un número");
                System.out.println("3- Buscar un número");
                System.out.println("4- Borrar por nombre");
                System.out.println("5- Buscar por nombre");
                System.out.println("6- Salir del programa");
                System.out.println("------------------------------------------------");
                System.out.println("Introduce una opcion:");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        añadirNuevoNumero();
                        break;
                    case 2:
                        borrarNumero();
                        break;
                    case 3:
                        buscarNumero();
                        break;
                    case 4:
                        borrarPorNombre();
                        break;
                    case 5:
                        buscarPorNombre();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opcion introducida incrrecta");
                }
            }catch (InputMismatchException e) {
                System.out.println("ERROR");
                sc.next();
            }
        } while (opcion != 6);
    }

    private static void añadirNuevoNumero() {
        String respuesta;
        do {
            boolean contactoValido = false;
            do {
                System.out.println("---------------Introduce un contacto nuevo--------------");

                System.out.println("* Introduce el nombre: ");
                String nombre = sc.next();
                Pattern pt = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú]*$");
                Matcher mat = pt.matcher(nombre);

                System.out.println("* Introduce su numero de telefono: ");
                String telefono = sc.next();
                Pattern pt1 = Pattern.compile("^(\\+34)?[0-9]{9}$");
                Matcher mat1 = pt1.matcher(telefono);

                if (mat.matches() && mat1.matches()) {
                    map.put(telefono, nombre);
                    System.out.println("Contacto introducido correctamente" + map);
                    contactoValido = true;
                } else {
                    System.out.println("Contacto introducido incorrecto, vuelvelo a intentar");
                    contactoValido = false;
                }
            } while (!contactoValido);

            boolean respuestaValida = false;
            do {
                System.out.println("Quieres introducir otro contacto mas?(SI/NO)");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("Respuesta incorrecta vveulvela a introducir");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));

    }



    private static void borrarNumero() {
        if (!map.isEmpty()) {
            boolean telefonoValido = false;
            String telefono;
            do {
                System.out.println("Introduce el numero que quieres borrar: ");
                telefono = sc.next();
                Pattern pt = Pattern.compile("^(\\+34)?[0-9]{9}$");
                Matcher mat = pt.matcher(telefono);
                if (mat.matches()) {
                    System.out.println("El numero introducido es valido");
                    telefonoValido = true;
                } else {
                    System.out.println("El numero introducido no esta valido");
                    telefonoValido = false;
                }
            }while(!telefonoValido);

            if (map.containsKey(telefono)) {
                map.remove(telefono);
                System.out.println("El numero borrado es : " + telefono);
                System.out.println("La lista de contactos estaria asi ahora: " + map);
            }else  {
                System.out.println("El numero introdicido no esta, vuelvelo a intentar");
            }
        }else {
            System.out.println("Debe de haber algun numero introducido en el map");
        }
    }

    private static void buscarNumero() {
        if (!map.isEmpty()) {
            boolean numeroValida = false;
            String numero;
            do {
                System.out.println("Introduce el contacto que quieres buscar: (POR NUMERO)");
                numero = sc.next();
                Pattern pt = Pattern.compile("^(\\+34)?[0-9]{9}$");
                Matcher mat = pt.matcher(numero);
                if (mat.matches()) {
                    System.out.println("El numero introducido es valido");
                    numeroValida = true;
                } else {
                    System.out.println("El numero introducido no esta valido");
                    numeroValida = false;
                }
            }while(!numeroValida);

            if (map.containsKey(numero)) {
                System.out.println("Numero enocntrado, es el " + map.get(numero));
            }else{
                System.out.println("Numero no encontrado, vuelvelo a intentar");
            }
        }else {
            System.out.println("Debe de haber algun numero introducido en el map");
        }
    }

    private static void borrarPorNombre() {
        String respuesta;
        do {
            if (!map.isEmpty()) {
                String nombre;
                boolean nombreValido = false;
                do {
                    System.out.println("Introduce el nombre que quieres borrar: ");
                    nombre = sc.next();
                    Pattern pt = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú]+$");
                    Matcher mat = pt.matcher(nombre);
                    if (mat.matches()) {
                        System.out.println("Nombre introducido corrctamente");
                        nombreValido = true;
                    } else {
                        System.out.println("nombre introducido incorrecto, vuelvelo a intertar");
                        nombreValido = false;
                    }
                }while(!nombreValido);


                String nombreEliminado = null;

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue().equalsIgnoreCase(nombre)) {
                        nombreEliminado = entry.getKey();
                    }
                }
                if (nombreEliminado != null) {
                    map.remove(nombreEliminado);
                    System.out.println("El nombre borrado es : " + nombre);
                    System.out.println("Asi quedaria la lista despues de borrar el nombre: " + map);
                } else {
                    System.out.println("No se ha borrado ningun nombre");
                }

            } else {
                System.out.println("Debe de haber algun numero introducido en el map");
            }


            boolean respuestaValida = false;
            do {
                System.out.println("Quieres introducir otro contacto mas?(SI/NO)");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI") || respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = true;
                } else {
                    System.out.println("Respuesta incorrecta vveulvela a introducir");
                    respuestaValida = false;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));


    }

    private static void buscarPorNombre() {
        if (!map.isEmpty()) {
            boolean nombreValido = false;
            String nombre;
            do {
                System.out.println("Introduce el contacto que quieres buscar: (POR NOMBRE) ");
                nombre = sc.next();
                Pattern pt = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú]+$");
                Matcher mat = pt.matcher(nombre);
                if (mat.matches()) {
                    System.out.println("Nombre introducido corrctamente");
                    nombreValido = true;
                } else {
                    System.out.println("nombre introducido incorrecto, vuelvelo a intertar");
                    nombreValido = false;
                }
            }while(!nombreValido);

            boolean encontrado = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {//if (entry.getValue().equalsIgnoreCase(nombre)) --> compara el nombre introducido con el valor del mapa, ignorando mayúsculas/minúsculas.
                if (entry.getValue().equalsIgnoreCase(nombre)) {
                    System.out.println("Contacto encontrado:");
                    System.out.println("Nombre: " + entry.getValue());//entry.getKey() --> devuelve la clave en este caso el número
                    System.out.println("Número: " + entry.getKey());//entry.getValue() --> devuelve el valor en este caso el nombre
                    encontrado = true;//si loencuentra saca true, encontrado
                }
            }

            if (!encontrado) {//si no lo encuentra pues entraria aqui y diria que no lo encunetra, encontrado = false , no seria distinto de enocntrado y entraria aqui
                System.out.println("El nombre introducido no existe en los contactos, vuelve a intentar.");
            }

        }else {
            System.out.println("Debe de haber algun numero introducido en el map");
        }
    }
}