package org.example.almacen.Modelo;

import org.example.almacen.Controladores.Modelo.AlmacenController;
import org.example.almacen.Controladores.Modelo.ProductoController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    private static String plantilla;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static Producto producto;

    public static Producto buscarProducto(String nombre) throws Exception
    {
        plantilla = " select * from productos where descripcion = ?";
        Connection con = org.example.demofx.utilidades.DBConnection.getConnection();
        ps = con.prepareStatement(plantilla);
        ps.setString(1,nombre);
        rs = ps.executeQuery();

        if(rs.next())
            return crearObjeto();

        throw new Exception("El producto no existe");
    }

    public static Producto crearObjeto() throws Exception{
        producto = new Producto();
        producto.setCodigo(rs.getInt(1));
        producto.setNombre(rs.getString(2));
        producto.setUnidades(rs.getInt(3));
        producto.setPrecio(rs.getFloat(4));

        // Buscar proveedores por producto
        ProductoController.buscarPorProducto(producto.getCodigo());

        return producto;
    }

    public static void actualizarStock(int codigo, int cant) {
        String sql = "UPDATE productos SET stock = stock + ? WHERE codigo = ?";

        try{
            Connection conn = org.example.demofx.utilidades.DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, cant);
            ps.setInt(2, codigo);

            ps.executeUpdate();

            org.example.demofx.utilidades.DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
