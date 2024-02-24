/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.JuegoEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
