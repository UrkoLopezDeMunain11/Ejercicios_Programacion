package org.example.almacen.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private static String plantilla;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Connection con;

    public static Proveedor crearObjetoProveedor(int codigoProveedor) throws Exception {
        plantilla = " select * from proveedores where codigo = ?";
        Connection con = org.example.demofx.utilidades.DBConnection.getConnection();
        ps = con.prepareStatement(plantilla);
        ps.setInt(1, codigoProveedor);
        ResultSet rsProv = ps.executeQuery();
        // Damos por hecho que existe
        rsProv.next();
        return new Proveedor(rsProv.getInt(1), rsProv.getString(2));
    }

    public static List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "select * from proveedores";
        try {
            Connection con = org.example.demofx.utilidades.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Proveedor(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }

    public static Proveedor buscarPorNombre(String nombre) {
        String sql = "select * from proveedores where nombre = ?";
        try {
            Connection con = org.example.demofx.utilidades.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Proveedor(rs.getInt(1), rs.getString(2));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
