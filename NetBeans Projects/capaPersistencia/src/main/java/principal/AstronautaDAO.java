/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

import entidades.AstronautaEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class AstronautaDAO {
    public void agregar(AstronautaEntidad astronauta) {
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        
        // Iniciamos la transacción.
        em.getTransaction().begin();

        em.persist(astronauta);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public AstronautaEntidad obtenerPorId(Long id) throws Exception {
        // Creamos el entity manager factory.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager em = emf.createEntityManager();
        
        AstronautaEntidad astronauta = em.find(AstronautaEntidad.class, id);
        
        if (astronauta == null) {
            throw new Exception("No se encontró el astronauta. :(");
        }
        
        return astronauta;
    }
}
