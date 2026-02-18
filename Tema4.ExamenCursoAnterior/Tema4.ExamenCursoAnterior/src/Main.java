import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Usuario;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {

        //CREACION DE PRODUCTOS Y GUARDARLOS EN MI LISTA
        Producto producto = new Producto("Manzana",12,4);
        listaProductos.add(producto);//PARA AÑADIRLOS A MI LISTA
        Producto producto1 = new Producto("Pera",10,2);
        listaProductos.add(producto1);
        Producto producto2 = new Producto("Naranja",5,7);
        listaProductos.add(producto2);

        JOptionPane.showMessageDialog(null, listaProductos);//PARA MOSTRAR LA LISTA

       // Pedido pedido = new Pedido(LocalDate.of(2026, 2, 18),);

        altaUsuarios();
        realizarPedidos();

    }


    private static void altaUsuarios() {
        JOptionPane.showMessageDialog(null, "Alta de usuarios");
        String respuesta;
        do {
            boolean nombreValido = false;
            String nombre;
            do {
                nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
                Pattern p1 = Pattern.compile("^[A-Z]([a-z]+)$");
                Matcher m1 = p1.matcher(nombre);
                if (m1.matches()) {
                    nombreValido = true;
                } else {
                    nombreValido = false;
                    JOptionPane.showMessageDialog(null, "El nombre del usuario no es valido, intentelo de nuevo");
                }
            } while (!nombreValido);

            String email = JOptionPane.showInputDialog("Ingrese el email del usuario");


            Usuario usuario = new Usuario(nombre, email);
            usuarios.add(usuario);

            boolean respuestaValida = false;
            do {
                respuesta = JOptionPane.showInputDialog("Deseea meter algun otro usuario???: (SI/NO)");
                if (!respuesta.equalsIgnoreCase("SI") || !respuesta.equalsIgnoreCase("NO")) {
                    respuestaValida = false;
                    JOptionPane.showMessageDialog(null, "Respuesta introducida incorrecta, vuelvelo a intentar con un SI o un NO");
                } else {
                    respuestaValida = true;
                }
            } while (!respuestaValida);

        } while (respuesta.equalsIgnoreCase("SI"));
    }


    private static void realizarPedidos() {


        if (listaProductos.isEmpty() && usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles, primero debes añadir productos y con los usuarios igual.");
        }else {
            String respuesta;
            do {
                Usuario usuarioSeleccionado = null;
                do {
                    String nombreUsuario = JOptionPane.showInputDialog("introduce el usuario q eres: ");
                    for (Usuario usuario : usuarios) {
                        if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                            JOptionPane.showMessageDialog(null, "usuario no encontrado vuelva a introducir otro nombre");
                            usuarioSeleccionado = usuario;

                        }
                        if (usuarioSeleccionado == null) {
                            JOptionPane.showMessageDialog(null, "Usuario no encontrado. Inténtalo de nuevo.");
                        }

                    }
                }while (usuarioSeleccionado == null);

                Pedido pedido = new Pedido(LocalDate.now(),usuarioSeleccionado,listaProductos);


                StringBuilder sb = new StringBuilder("Productos disponibles:\n");
                for (Producto p : listaProductos) {
                    sb.append(p.getNombre())
                            .append(" - $").append(p.getPrecio())
                            .append(" (Stock: ").append(p.getStock()).append(")\n");
                }

                boolean productoValido = false;
                Producto productoSeleccionado = null;
                do {
                    String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto q quiere: ");
                    for (Producto producto : listaProductos) {
                        if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                            productoSeleccionado = producto;
                            productoValido=true;
                        }else {
                            productoValido = false;
                        }
                    }
                }while(!productoValido);

                boolean cantidadvalida = false;
                do {
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos q quieres de ese producto:???"));
                    if (cantidad < 0) {
                        JOptionPane.showMessageDialog(null, "La cantidad debe ser menor a 0");
                        cantidadvalida = false;
                    }else if (cantidad < productoSeleccionado.getStock()) {
                        JOptionPane.showMessageDialog(null, "Stock insuficietne");
                        cantidadvalida = false;
                    }else{
                        cantidadvalida = true;
                    }

                }while(!cantidadvalida);

                pedidos.add(pedido);


                boolean respuestaValida = false;
                do {
                    respuesta = JOptionPane.showInputDialog("Deseea meter algun otro usuario???: (SI/NO)");
                    if (!respuesta.equalsIgnoreCase("SI") || !respuesta.equalsIgnoreCase("NO")) {
                        respuestaValida = false;
                        JOptionPane.showMessageDialog(null, "Respuesta introducida incorrecta, vuelvelo a intentar con un SI o un NO");
                    } else {
                        respuestaValida = true;
                    }
                } while (!respuestaValida);

            } while (respuesta.equalsIgnoreCase("SI"));

        }
    }
}