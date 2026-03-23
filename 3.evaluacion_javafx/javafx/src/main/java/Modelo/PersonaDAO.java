package Modelo;

import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

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
            ps.setDate(5,p.getFecha_nacimiento());
            ps.setInt(6, p.getEdad());

            ps.executeUpdate();

            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
