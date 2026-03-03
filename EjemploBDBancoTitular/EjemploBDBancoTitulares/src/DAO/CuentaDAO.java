package DAO;

import Modelo.Cuenta;
import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CuentaDAO {
    public static void crearCuenta(Cuenta Cuenta ) {
        String sql = "INSERT INTO cuentas numeroCuenta, saldo) VALUES (?, ?)";

        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, Cuenta.getNumeroCuenta());
            ps.setDouble(2, Cuenta.getSaldo());
            ps.executeUpdate();

            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void modificarCuenta(Cuenta cuenta) {
        String sql = "UPDATE cuentas SET numeroCuenta = ?, saldo = ? WHERE numeroCuenta = ?";
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cuenta.getNumeroCuenta());
            ps.setDouble(2, cuenta.getSaldo());
            int n = ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void borrarCuenta(String numeroCuenta) {
        String sql = "Delete from cuentas where numeroCuenta = ?";
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, numeroCuenta);
            int n = ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void listarCuentas() {
        String sql = "SELECT * FROM cuentas";
            try{
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.executeQuery();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

}
