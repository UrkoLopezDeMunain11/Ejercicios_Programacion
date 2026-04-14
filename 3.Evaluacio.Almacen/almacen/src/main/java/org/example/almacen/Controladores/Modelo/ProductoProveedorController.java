package org.example.almacen.Controladores.Modelo;

import org.example.almacen.Modelo.*;

import java.util.List;

public class ProductoProveedorController {

    public static List<Proveedor> buscarPorProducto(int id) throws Exception
    {
        return ProductoProveedorDAO.buscarPorProducto(id); // lammar al dao para que me devuelva la lista de proveedores de ese producto, asociada a ese prodcvuto
    }


    public static Proveedor crearObjetoProveedor(int codigoProveedor) throws Exception
    {
        return AlmacenController.crearObjetoProveedor(codigoProveedor);
    }
}
