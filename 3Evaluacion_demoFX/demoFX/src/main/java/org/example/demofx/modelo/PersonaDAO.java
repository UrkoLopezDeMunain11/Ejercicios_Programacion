package org.example.demofx.modelo;

import org.example.demofx.utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonaDAO {
    public void insertar(Persona p) {
        String sql = "INSERT INTO personas (nombre,apellidos,dni,telefono,fecha_nacimiento,edad) VALUES (?,?,?,?,?,?)";

        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getDni());
            ps.setString(4, p.getTelefono());
            ps.setDate(5, java.sql.Date.valueOf(p.getFechaNacimiento()));
            ps.setInt(6, p.getEdad());

            ps.executeUpdate();

            System.out.println("Titular insertado correctamente.");
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO)Error al insertar titular: " + e.getMessage());
        }
    }


}
