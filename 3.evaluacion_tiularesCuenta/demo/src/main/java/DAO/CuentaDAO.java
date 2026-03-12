package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CuentaDAO {
    public static void crearCuenta(Cuenta Cuenta ) {
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(Cuenta);
            em.getTransaction().commit();
            System.out.println(" (DAO)Titular insertado correctamente.");
        } catch (Exception e) {
            System.out.println(" (DAO)Error al insertar titular: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        em.close();
    }

    public static void modificarCuenta(Cuenta cuenta) {
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try{
            em.getTransaction().begin();
            Cuenta cuentaExistene = em.find(Cuenta.class, cuenta.getId());
            if(cuentaExistene == null){
                System.out.println(" (DAO) Cuenta no borrado.");
                throw new Exception(" No se encontró ninguna cuenta con ese numero de cuenta proporcionado.");
            }else{
                cuentaExistene.setNumeroCuenta(cuenta.getNumeroCuenta());
                cuentaExistene.setSaldo(cuenta.getSaldo());
                em.merge(cuentaExistene);
                em.getTransaction().commit();
                System.out.println(" (DAO) Cuenta modificado correctamente.");
            }

        }catch(Exception e){
            System.out.println(" (DAO) Error al modificar titular: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
    }

    public static void borrarCuenta(String numeroCuenta) {
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            
            em.getTransaction().begin();
            Cuenta cuenta = em.find(Cuenta.class, numeroCuenta);
            if (cuenta == null) {
                System.out.println(" (DAO) Cuenta no borrado.");
                throw new Exception(" No se encontró ninguna cuenta con ese numero de cuenta proporcionado.");
            }else{
                em.remove(cuenta);// borro la cuenta entera que he encontrado al meter el numero de cuenta
                em.getTransaction().commit();
                System.out.println(" (DAO)Titular borrado correctamente.");
            }
        }catch (Exception e){
            System.out.println(" (DAO) Error al borrar titular: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
    }

    public List<Cuenta> listarCuentas() {
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try{
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t ", Titular.class);
        }catch(Exception e){
            System.out.println(" (DAO) Error al listar titulares: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally{
            em.close();
        }
        return List.of();
    }
}
