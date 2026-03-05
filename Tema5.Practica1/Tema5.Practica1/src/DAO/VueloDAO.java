package DAO;

import Modelo.Vuelo;
import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static Utilidades.DBConnection.closeConnection;

public class VueloDAO {

    public static void insertarVuelo(Vuelo vuelo) {
        String sql = "INSERT INTO vuelos (cod_vuelo, fecha_salida, destino, procedencia) VALUES (?, ?, ?, ?)";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, vuelo.getCod_vuelo());
            ps.setDate(2, new java.sql.Date(vuelo.getFecha_salida().getTime()));
            ps.setString(3, vuelo.getDestino());
            ps.setString(4, vuelo.getProcedencia());
            ps.executeUpdate();

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void eliminarVuelo(String codVuelo) {
        String sql = "DELETE FROM vuelos WHERE cod_vuelo = ?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, codVuelo);
            int n = ps.executeUpdate();

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void modificarVuelo(String codVuelo, String nuevoDestino, Date nuevaFecha, String nuevaProcedencia) {
        String sql = "UPDATE vuelos SET destino = ?, fecha_salida = ?, procedencia = ? WHERE cod_vuelo = ?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nuevoDestino);
            ps.setDate(2, new java.sql.Date(nuevaFecha.getTime()));
            ps.setString(3, nuevaProcedencia);
            ps.setString(4, codVuelo);
            int n = ps.executeUpdate();

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
