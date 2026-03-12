package DAO;

import Modelo.Vuelo;
import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Utilidades.DBConnection.closeConnection;

public class VueloDAO {

    public void insertarVuelo(Vuelo vuelo) {
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


    public String eliminarVuelo(String codVuelo) {
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
        return sql;
    }


    public void modificarVuelo(String codVuelo, String nuevoDestino, Date nuevaFecha, String nuevaProcedencia) {
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

    public static Vuelo obtenerVuelosPorDestino(String destino) {
        String sql = "Select * from vuelos where destino = ?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {// tiene que ser while y no if porque puede haber mas de una vuelo con ese destino
                return new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia"),
                        null);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Vuelo> obtenerVuelosPorFecha(LocalDate fecha) {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "Select * from vuelos where fecha_salida = ?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while(rs.next()){// tiene que ser while y no if porque puede haber mas de una vuelo con esa fecha
                vuelos.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia"),
                        null));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return vuelos;
    }

    public List<Vuelo> obtenerVuelosPorOrigen(String origen) {
        List<Vuelo> lista = new ArrayList<>();
        String sql = "Select * from vuelos where origen = ?";


        try{

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, origen);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){// tiene que ser while y no if porque puede haber mas de una vuelo con ese origen
                lista.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia"),
                        null));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
