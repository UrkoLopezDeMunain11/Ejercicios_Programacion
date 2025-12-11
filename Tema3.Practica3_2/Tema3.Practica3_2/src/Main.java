import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Queue<String> fechas = new LinkedList<>();
    static Queue<String> productos = new LinkedList<>();

    public static void main(String[] args) {
        insertarProductosFecha();
        eliminarProductosCaducados();



    }

    private static void insertarProductosFecha() {

        String respuesta;
        do {

            boolean productoValido = false;
            do {
                System.out.println("Introduce el nombre del producto: ");
                String producto = sc.nextLine();
                Pattern pt = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú]");
                Matcher mat = pt.matcher(producto);
                if (mat.matches()) {
                    productos.add(producto);
                    System.out.println("Producto" + producto + "añadido correctamnete");
                    productoValido = true;
                } else {
                    System.out.println("El nombre del producto introducido no es valido");
                    productoValido = false;
                }
            } while (!productoValido);


            boolean fechaValida = false;
            do {
                try {
                    System.out.println("----------Introduce la fecha del producto-----------");
                    System.out.println("introduce el año");
                    int a = sc.nextInt();

                    System.out.println("introduce el mes");
                    int m = sc.nextInt();

                    System.out.println("introduce el dia");
                    int d = sc.nextInt();

                    LocalDate d1 = LocalDate.of(a, m, d);
                    System.out.println(d1);
                    fechaValida = true;
                    fechas.add(d1.toString());
                } catch (InputMismatchException e) {
                    System.out.println("ERROR");
                    sc.next();
                    fechaValida = false;
                } catch (DateTimeException e) {
                    System.out.println("ERROR");
                    sc.next();
                    fechaValida = false;
                }
            }while(!fechaValida);

            boolean respuestaValida = false;
            do {
                System.out.println("Quieres introducir mas productos?(SI/NO): ");
                respuesta = sc.nextLine();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("Respuesta incorrecta");
                    respuestaValida = false;
                } else {
                    System.out.println("Respuesta correcta");
                    respuestaValida = true;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("NO"));
    }


    private static void eliminarProductosCaducados() {
        String respuesta;
        do {
            boolean fechaValida = false;
            LocalDate fechaCadu = null;
            do {
                try {
                    System.out.println("-------Solicitar fecha------");
                    System.out.println("introduce el año");
                    int a = sc.nextInt();

                    System.out.println("introduce el mes");
                    int m = sc.nextInt();

                    System.out.println("introduce el dia");
                    int d = sc.nextInt();

                    fechaCadu = LocalDate.of(a, m, d);
                    System.out.println(fechaCadu);
                    fechaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("ERROR");
                    sc.next();
                    fechaValida = false;
                } catch (DateTimeException e) {
                    System.out.println("ERROR");
                    sc.next();
                    fechaValida = false;
                }
            } while (!fechaValida);


            LocalDate fechaProducto = LocalDate.parse(fechas.peek()); // obtenemos la fecha, porq con string no se podria comparar con el locadate de fechasCadu, y le opnemos otroo nombre fechaProducto
            if (fechaProducto.isAfter(fechaCadu)) {
                System.out.println("El producto eliminado es: " + productos.peek());
                fechas.poll(); // borro la fecha q sea menor q la fechaCadu
                productos.poll();// y ahora el producto
            } else {
                System.out.println("No se ha eliminado ningun producto");
            }

            System.out.println("Las listan quesarian asi: " + productos + fechas);
            sc.nextLine();

            System.out.print("¿Quieres eliminar más productos caducados? (SI/NO): ");
            respuesta = sc.nextLine();

        } while (respuesta.equalsIgnoreCase("SI"));
    }

}