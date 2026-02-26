package Modelo;

import Utilidades.DBConnection;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitularDAO {
    public static void insertarTitular(Titular titular) {
        // hay q insertale datos a las columnas q estan sin datos ?
        String platilla = "INSERT INTO titular (nombre, dni) VALUES ( ?, ?)";
        try {
            Connection con = DBConnection.getConnection();//conexcion
            PreparedStatement ps = con.prepareStatement(platilla);


            ps.setString(1, titular.getNombre());// aqui estoy sustituyendo las interrogaciones por dato
            ps.setString(2, titular.getDni());
            ps.executeUpdate();// ejecuta la acicion insertert pero en vez de con ? con los nusdatosd q le hemos pasado
            // cuando sea insert update o delete, Executequery cuando sea select

            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public  static void eliminar(String dni) {
        String platilla = "DELETE FROM titular WHERE dni = ?";// sentencia para eliminar poir el dni q le pasemos
        try {
            Connection con = DBConnection.getConnection();// conexion
            PreparedStatement ps = con.prepareStatement(platilla);

            ps.setString(1, dni);// pasamo el dni al parametro ?, lo sutituimos el dni por ?
            int n = ps.executeUpdate();// se ejecuta ese accion de delte pero en vez de con el ? con el dni q le hemos pasado

            if (n > 0) {// le tengo q psasar q si no ec¡ncuentra el dni q diga q no se enocntro, en las vista tengo peusto algo asi pero el dao no sabe lo que pasa, la vista modelo no se hablan, asiq en la vista asiq lo pongo aqui tambien
                System.out.println("Titular eliminado correctamente.");
            } else {
                System.out.println("No se encontró un titular con el DNI proporcionado.");
            }

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void actualizarTitular(Titular titular) {
        String plantilla = "UPDATE titular SET nombre = ?, dni = ?  WHERE dni = ?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(plantilla);

            ps.setString(1, titular.getNombre());// nombre nuevo
            ps.setString(2, titular.getDni());// dni nuevo
            ps.setString(3, titular.getDni());// el dni viejo
            int n = ps.executeUpdate();

            if (n > 0) {
                System.out.println("Titular actualizado correctamente.");
            } else {
                System.out.println("No se encontró un titular con el DNI proporcionado.");
            }

            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Titular> listaTitulares() {
        List <Titular> lista = new ArrayList<>();
        String plantilla = "SELECT * FROM titular";
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(plantilla);

            while (rs.next()) {
                lista.add(new Titular(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni")));
            }

            DBConnection.closeConnection();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }


    public static Titular buscar(String dni) {
        String plantilla = "SELECT * FROM titular WHERE dni = ?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"));
            }

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
