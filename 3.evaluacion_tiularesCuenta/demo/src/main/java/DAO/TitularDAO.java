package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManagerFactory;


public class TitularDAO {

    private EntityManagerFactory emf;
    private Titular t;

    public TitularDAO()
    {
        this.emf = DBConnection.getEMF();
    }

    public void insertar(Titular titular) {
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();// habro el entitymanager
            em.persist(titular);// esto es lo que hace el insert
            em.getTransaction().commit();// si hace falta porq es un insert, pero cuando sea consulta no hara falta el commit
            System.out.println(" (DAO)Titular insertado correctamente.");
        } catch (Exception e) {
            System.out.println(" (DAO)Error al insertar titular: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();// lo cierro vaya bien o vaya mal. Igual que lo habro al principio aqui cierro el etitymanager
        }
    }

    public int borrar(int id) throws Exception{// para borrar primero hay q buscar si existe por la clave primaria y si lo encuentra, borrarlo
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titular = em.find(Titular.class, id); // primero busco y despues borro. Aunq no es obligatorio borrar
            if (titular == null) {
                System.out.println(" (DAO) Titular no borrado.");
                throw new Exception(" No se encontró ningún titular con el ID proporcionado.");
            }else {
                em.remove(titular); // aqui lo borro
                em.getTransaction().commit();
                System.out.println(" (DAO) Titular borrado correctamente.");
            }
        }catch (Exception e){
            System.out.println(" (DAO) Error al borrar titular: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
        return id;
    }

    public Titular buscarPorId(int id) {// aqui al ser id la clave primaria, habia q buscarla como todas las claves
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            Titular tiutlar = em.find(Titular.class, id);
            em.getTransaction().commit();
            return tiutlar;
        }catch (Exception e){
            System.out.println(" (DAO) Error al buscar titular: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
        return null;
    }

    public Titular buscarPorDni(String dni) {// esta al no ser la clave primaria no se haria con el find se haria de este modo, con TypedQuery
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try{
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class);
            query.setParameter("dni", dni);

            return query.getSingleResult();

        }catch (Exception e){
            return null;
        }finally {
            em.close();
        }
    }

    public ArrayList<Titular>  buscarPorNombre(String nombre) {// aqui igual que en la de buscar por DNI
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.dni LIKE :nombre", Titular.class);
            query.setParameter("nombre", "%" + nombre + "%");// le pasamos con % para q busque concidencias parciales, q busco los nombres q contengan ese nombre en su nombre completo
            return new ArrayList<>(query.getResultList());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
        return null;
    }

    public void modificar(Titular titular)  {
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titularExistente = em.find(Titular.class, titular.getId());// antes de modificar tengo q buscar si existe ese titular con  ese id
            if(titularExistente == null){
                System.out.println(" (DAO) Titular no borrado.");
                throw new Exception(" No se encontró ningun titular con ese id proporcionado.");
            }else{
                titularExistente.setDni(titular.getDni());
                titularExistente.setNombre(titular.getNombre());
                em.merge(titularExistente); // para guardar la modificacion dentro de la tabla correspondiente
                em.getTransaction().commit();
                System.out.println(" (DAO) Titular modificado correctamente.");
            }
        } catch (Exception e) {
            System.out.println(" (DAO) Error al modificar titular: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public List<Titular> listarTodos() {// lo mismo que en las otras dos de arriba
        EntityManager em = DBConnection.getEMF().createEntityManager();
        try {
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t ORDER BY t.dni ASC", Titular.class);// los listo y los ordenos por el dni;
            return query.getResultList(); // devuelve la lista de los objetos
        }catch (Exception e){
            System.out.println(" (DAO) Error al listar titulares: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }finally {
            em.close();
        }
    }

    //-- Si el clave primaria se busca con el FIND, si no es clave primaria y te dice busca por este se busca con TypedQuery

}

