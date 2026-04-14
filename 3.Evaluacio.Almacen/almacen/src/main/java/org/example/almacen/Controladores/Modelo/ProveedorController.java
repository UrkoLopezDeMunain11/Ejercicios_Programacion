package org.example.almacen.Controladores.Modelo;

import org.example.almacen.Modelo.Proveedor;
import org.example.almacen.Modelo.ProveedorDAO;

import java.util.List;

public class ProveedorController
{
    public static Proveedor crearObjetoProveedor(int codigo) throws Exception
    {
        return ProveedorDAO.crearObjetoProveedor(codigo);
    }

    // paara obtener todos los proveedores, lista de los proveedores
    public static List<Proveedor> obtenerTodosProveedores() throws Exception {
        return ProveedorDAO.listar();
    }

    // para buscar proveedor por nombre
    public static Proveedor buscarPorNombre(String nombre) throws Exception {
        return ProveedorDAO.buscarPorNombre(nombre);
    }
}
