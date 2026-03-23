package Modelo;

import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonaDAO {

    public static void insertarPersona(Persona p) {
        String sql = "INSERT INTO persona (nombre,apellidos,dni,telefono,fecha_nacimiento,edad) VALUES (?,?,?,?,?,?)";

        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getDNI());
            ps.setString(4, p.getTelefono());
            ps.setDate(5, java.sql.Date.valueOf(p.getFecha_nacimiento()));// para cambiar de localdate a date
            ps.setInt(6, p.getEdad());

            ps.executeUpdate();

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void actualizarPersona(Persona p) {
        String sql = "UPDATE persona SET nombre = ?, apellido = ?, fecha_nacimiento = ?, telefono = ?, edad = ? WHERE dni = ? ";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setDate(3, java.sql.Date.valueOf(p.getFecha_nacimiento()));
            ps.setString(4, p.getTelefono());
            ps.setInt(5, p.getEdad());

            ps.executeUpdate();

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarPersona(String dni) {
        String sql = "DELETE FROM persona WHERE dni = ?";

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,dni);

            ps.executeUpdate();

            DBConnection.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
