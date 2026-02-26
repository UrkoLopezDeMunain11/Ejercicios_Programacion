package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
// aqui se hace la conexion a mi base de datos de phpmyadmin
        private static final String URL = "jdbc:mysql://localhost:3306/ejerciciotitular"; // aqui cambiara el final, poner el nombre del ejercicio q le hayas puest en phpmyadmin
        private static final String USER = "root";// el usuario que tenga en phpmyadmin, por defecto es root
        private static final String PASS = "usbw";// la contraseña que tenga en phpmyadmin, por defecto es usbw
        private static Connection con  = null;

    public static Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(URL, USER, PASS);// aqui se hace la conexion a la base de datos, con los datos que hemos puesto antes
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// para cargar el driver, sera igual

        }catch(ClassNotFoundException e){
            System.out.println("Error: No se encontró el Driver de MySQL");
        }
    }

}
