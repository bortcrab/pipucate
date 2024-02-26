/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.JuegoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author jorge
 */
public class JuegoDAO {
    public JuegoEntidad obtenerPorID(Long id) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se obtiene el juego.
        JuegoEntidad juegoObtenido = em.find(JuegoEntidad.class, id);
        
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();

        // Se devuelve el juego obtenido.
        return juegoObtenido;
    }

    public void guardar(JuegoEntidad juego) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se comienza la transacción.
        em.getTransaction().begin();

        // Se persiste el juego.
        em.persist(juego);

        // Se hace el commit.
        em.getTransaction().commit();
        // Se imprime un mensajito de éxito.
        System.out.println("Inserción exitosa.");
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();
    }

    public void editar(JuegoEntidad juego) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se comienza la transacción.
        em.getTransaction().begin();

        // Se modifica el juego.
        em.merge(juego);

        // Se hace el commit.
        em.getTransaction().commit();
        
        // Se imprime un mensajito de éxito.
        System.out.println("Edición exitosa.");
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();
    }

    public void eliminar(JuegoEntidad juego) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se comienza la transacción.
        em.getTransaction().begin();

        // Aquí obtuve primero el juego directamente con el método find porque si
        // lo hacía con el obtenerPorID() me daba error. :(
        JuegoEntidad juegoObtenido = em.find(JuegoEntidad.class, juego.getId());
        
        // Se elimina el juego.
        em.remove(juegoObtenido);

        // Se hace el commit.
        em.getTransaction().commit();
        
        // Se imprime un mensajito de éxito.
        System.out.println("Eliminación exitosa.");
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();
    }
    
    /**
     * Método para devolver una lista de videojuegos cuyo nombre contenga la palabra
     * Mario.
     * @return Lista de videojuegos cuyos nombres contengan la palabra Mario.
     */
    public List<JuegoEntidad> consultarMario() {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();
        // Construimos una instancia de CriteriaBuilder.
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        // Creamos un objeto CriteriaQuery.
        CriteriaQuery<JuegoEntidad> criteriaQuery = criteriaBuilder.createQuery(JuegoEntidad.class);
        // Creamos una instancia del tipo Root para representar la entidad principal.
        Root<JuegoEntidad> root = criteriaQuery.from(JuegoEntidad.class);
        
        // Mediante el método select(), se especifica que la consulta seleccionará
        // todos los campos de JuegoEntidad.
        criteriaQuery.select(root);
        // A la consulta le añadimos una cláusula WHERE donde indicamos que sólo
        // se obtengan los videojuegos con "Mario" en el nombre.
        criteriaQuery.where(criteriaBuilder.like(root.get("nombre"), "%Mario%"));

        // Se manda a ejecutar la consulta y se obtiene una lista con los resultados.
        List<JuegoEntidad> results = em.createQuery(criteriaQuery).getResultList();
        
        return results;
    }
    
    /**
     * Método para devolver una lista de videojuegos que hayan sido lanzados en
     * enero de 2022.
     * @return Lista de videojuegos que hayan sido lanzados en enero de 2022.
     */
    public List<JuegoEntidad> consultarEnero() {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();
        // Construimos una instancia de CriteriaBuilder.
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        // Creamos un objeto CriteriaQuery.
        CriteriaQuery<JuegoEntidad> criteriaQuery = criteriaBuilder.createQuery(JuegoEntidad.class);
        // Creamos una instancia del tipo Root para representar la entidad principal.
        Root<JuegoEntidad> root = criteriaQuery.from(JuegoEntidad.class);
        
        // Creamos un predicado donde especificamos varias condiciones con el método
        // and(), la primera es para verificar que el mes de lanzamiento del juego
        // sea enero y la segunda para verificar que el año de lanzamiento sea 2022.
        Predicate predicate = criteriaBuilder.and(
            criteriaBuilder.equal(criteriaBuilder.function("MONTH", Integer.class, root.get("lanzamiento")), 1),
            criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, root.get("lanzamiento")), 2022)
        );

        // Mediante el método select(), se especifica que la consulta obtendrá
        // todos los campos de JuegoEntidad y con el método where se aplican las
        // condiciones del predicado.
        criteriaQuery.select(root).where(predicate);

        // Se manda a ejecutar la consulta y se obtiene una lista con los resultados.
        List<JuegoEntidad> results = em.createQuery(criteriaQuery).getResultList();
        
        return results;
    }
}
