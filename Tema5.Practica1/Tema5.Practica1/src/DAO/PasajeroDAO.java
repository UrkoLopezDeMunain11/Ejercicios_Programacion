package DAO;

import Modelo.Pasajero;
import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {
    public static void insertarPasajero(Pasajero pasajero) {
        String sql = "INSERT INTO pasajeros (dni, nombre, telefono, cod_vuelo) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getTelefono());
            ps.setString(4, pasajero.getCod_vuelo());
            ps.executeUpdate();

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void borrarPasajero(String dni) {
        String sql = "DELETE FROM pasajeros WHERE dni = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            int n = ps.executeUpdate();


            if (n != 1) {
                System.out.println("Titular no borrado.");
                // Mensaje para el usuario
                throw new Exception(" No se encontró ningún titular con el ID proporcionado.");
            } else {
                System.out.println("Titular borrado correctamente.");
            }


            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void modificarPasajero(String dni, String nuevoNombre, String nuevoTelefono, String nuevoCodVuelo) {
        String sql = "UPDATE pasajeros SET nombre = ?, telefono = ?, cod_vuelo = ? WHERE dni = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoTelefono);
            ps.setString(3, nuevoCodVuelo);
            ps.setString(4, dni);
            int n = ps.executeUpdate();

            if (n != 1) {
                System.out.println("Titular no modificado.");
                throw new Exception(" No se encontró ningún titular con el ID proporcionado.");
            } else {
                System.out.println("Titular modificado correctamente.");
            }

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Pasajero obtenerPasajeroPorDNI(String dni) {
        String sql = "Select * FROM pasajeros WHERE dni = ?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // aqui si if y no while porq solo hay un pasajero con ese dni
                return new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo"));
            }

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public static List<Pasajero> obtenerPasajerosPorVuelo(String cod_vuelo) {
        String sql = "SELECT * FROM pasajeros WHERE cod_vuelo = ?";
        List<Pasajero> pasajeros = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cod_vuelo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {// tiene que ser while y no if porque puede haber mas de una
                Pasajero pasajero = new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                );
                pasajeros.add(pasajero);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pasajeros;
    }
}
