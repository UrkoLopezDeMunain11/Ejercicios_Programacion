package org.example.almacen.Controladores.Modelo;

import javafx.scene.control.ComboBox;
import org.example.almacen.Modelo.Producto;
import org.example.almacen.Modelo.Proveedor;

import java.util.List;

public class AlmacenController {
    // "Jefe" de todos los controllers.

    private static Producto producto;
    private static List<Proveedor> listaProveedores;

    public static void buscarProducto(String nombre) throws Exception
    {
        producto = ProductoController.buscarProducto(nombre);// se busca el producto por su nombre
        producto.setListaProveedores(listaProveedores); // asignar la lista al objeto producto de los proveedores q tenrad ese producto
    }

    public static void buscarPorProducto(int codigo) throws Exception
    {
        // buscar proveedores de un producto. los proveedores asociados a ese prodcuto
        listaProveedores = ProductoProveedorController.buscarPorProducto(codigo);
    }

    public static Proveedor crearObjetoProveedor(int codigoProveedor) throws Exception
    {
        return ProveedorController.crearObjetoProveedor(codigoProveedor);
    }

    public static void llenarCombo(ComboBox<String> cbProveedores) throws Exception
    {
        if(listaProveedores == null) {
            for (Proveedor p : listaProveedores) {
                cbProveedores.getItems().add(p.getNombre());
            }
        }
    }

    // para cambiar el stock del producto q se ha vendidio o se ha comprado
    public static void registrarCompra(String nombre, String unidades, String precio, String proveedor, String importe) throws Exception {
        int cant = Integer.parseInt(unidades);
        double prec = Double.parseDouble(precio);
        double imp = Double.parseDouble(importe);

        // actualizamos el Stock, le smeunamos unidades
        ProductoController.actualizarStock(producto.getCodigo(), cant);

    }

    public static void registrarVenta(String nombre, String unidades, String precio, String cliente, String importe) throws Exception {
        int cant = Integer.parseInt(unidades);
        double prec = Double.parseDouble(precio);
        double imp = Double.parseDouble(importe.replace(",", ".")); // Por si viene con coma de la vista

        // hay que mirar primero si tenemos los sufccientos priductos de los q se quieren para vender
        if (producto.getUnidades() < cant) {
            throw new Exception("No tenemos la cantidad de ese prodcutp" + producto.getUnidades());
        }

        // Actualizamos el stock, le restamos unidades
        ProductoController.actualizarStock(producto.getCodigo(), -cant);
    }


}
