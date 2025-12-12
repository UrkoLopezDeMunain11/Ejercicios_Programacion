import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                Pattern pt = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú]*");
                Matcher mat = pt.matcher(producto);
                if (mat.matches()) {
                    productos.add(producto);
                    System.out.println("Producto" +" "+ producto +" "+ "añadido correctamnete");
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

                    sc.nextLine();

                    LocalDate d1 = LocalDate.of(a, m, d);
                    System.out.println(d1);
                    fechas.add(d1.toString());
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
            }while(!fechaValida);

            boolean respuestaValida = false;
            do {
                System.out.println("Quieres introducir mas productos?(SI/NO): ");
                respuesta = sc.nextLine();
                if (!respuesta.equalsIgnoreCase("SI") && !respuesta.equalsIgnoreCase("NO")) {
                    System.out.println("Respuesta incorrecta");
                } else {
                    System.out.println("Respuesta correcta");
                    respuestaValida = true;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));
    }


    private static void eliminarProductosCaducados() {
        String respuesta;
        do {
            LocalDate fechaCadu = null;
            System.out.println("La fecha de hoy es: " + fechaCadu + " " + "si la fecha del producto es anterior a esta se eliminara el producto, PRODUCTO CADUCADO");

            Queue<String> productosTemp = new LinkedList<>();
            Queue<String> fechasTemp = new LinkedList<>();
            fechaCadu = LocalDate.now();

            while (!productos.isEmpty()) {
                //si e primero es yogurt, leche, pan , coge ese primero y la primera fecha hace estas dos de abajp y luego el if o el ese dependiendo de la feha
                //si es anterior a la fevha , se elimina entonces el yogurt y ya solo queadaria leche y pan
                //hacemos estas dos de abjabo y claro ahora el primero es leche, entonces hacemos lo mismo q con yogurt y quedaria el la lista al hacer las dos de abajo pan
                //si es depues de la fehca de cadu, entra en el else y entonces guardamos leche en las nuevas lista y lugeo y ala metemos en las listas del principio
                //ahora con pan si es como leche igual q leche si es coo yogur igul
                String producto = productos.poll(); // sacamos y eliminamos el primer producto de la fila y lo guardamos en productos entonces el la lista prodcutos ahora mismo estaria leche y pan
                LocalDate fechaProducto = LocalDate.parse(fechas.poll()); // lo mismo, primera fecha y lo guardamos en fechaProducto


                if (fechaProducto.isBefore(fechaCadu)) {//si esa fecha es de antes entra en este entonces se elimina ese producto
                    System.out.println("Producto eliminado: " + producto);
                } else {
                    productosTemp.add(producto);
                    fechasTemp.add(fechaProducto.toString());
                }
            }

            productos = productosTemp;
            fechas = fechasTemp;

            System.out.println("Las listan quesarian asi: " + productos + fechas);
            sc.nextLine();

            System.out.print("¿Quieres eliminar más productos caducados? (SI/NO): ");
            respuesta = sc.nextLine();

        } while (respuesta.equalsIgnoreCase("SI"));
    }

}