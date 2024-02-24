/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.JugadorEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jorge
 */
public class JugadorDAO {
    public JugadorEntidad obtenerPorID(Long id) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se obtiene el jugador.
        JugadorEntidad jugadorObtenido = em.find(JugadorEntidad.class, id);
        
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();

        // Se retorna el jugador obtenido.
        return jugadorObtenido;
    }

    public void guardar(JugadorEntidad jugador) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se comienza la transacción.
        em.getTransaction().begin();

        // Se persiste el jugador.
        em.persist(jugador);

        // Se hace el commit.
        em.getTransaction().commit();
        
        // Se imprime un mensajito de éxito.
        System.out.println("Inserción exitosa.");
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();
    }

    public void editar(JugadorEntidad jugador) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se comienza la transacción.
        em.getTransaction().begin();

        // Se modifica el jugador.
        em.merge(jugador);

        // Se hace el commit.
        em.getTransaction().commit();
        
        // Se imprime un mensajito de éxito.
        System.out.println("Edición exitosa.");
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();
    }

    public void eliminar(JugadorEntidad jugador) {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();

        // Se comienza la transacción.
        em.getTransaction().begin();

        // Aquí obtuve primero el jugador directamente con el método find porque si
        // lo hacía con el obtenerPorID() me daba error. :(
        JugadorEntidad jugadorObtenido = em.find(JugadorEntidad.class, jugador.getId());
        
        // Se elimina el jugador.
        em.remove(jugadorObtenido);

        // Se hace el commit.
        em.getTransaction().commit();
        
        // Se imprime un mensajito de éxito.
        System.out.println("Eliminación exitosa.");
        // Se cierran entity manager y la fábrica.
        em.close();
        emf.close();
    }
}
