package org.example.almacen.Controladores.Modelo;

import org.example.almacen.Modelo.Producto;
import org.example.almacen.Modelo.ProductoDAO;

public class ProductoController {

    public static Producto buscarProducto(String nombre) throws Exception
    {
        Producto producto = ProductoDAO.buscarProducto(nombre);
        if(producto==null){
            throw new Exception("El producto no existe");
        }
        return producto;
    }

    public static void buscarPorProducto(int codigo) throws Exception
    {
        AlmacenController.buscarPorProducto(codigo);
    }


    public static void actualizarStock(int codigo, int cant) {
        ProductoDAO.actualizarStock(codigo, cant); // para q haga un update en el dao y actualizce el stock
    }
}
