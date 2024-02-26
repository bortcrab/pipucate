/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.JuegoEntidad;
import entidades.LogroEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jorge
 */
public class LogroDAO {
    /**
     * Método para devolver una lista de logros que tengan más de 10 puntos
     * de premio.
     * @return Lista de logros con más de 10 puntos de premio.
     */
    public List<LogroEntidad> consultarPuntos() {
        // Se crea una fábrica de entity managers.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        // Se crea un entity manager.
        EntityManager em = emf.createEntityManager();
        // Construimos una instancia de CriteriaBuilder.
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        // Creamos un objeto CriteriaQuery.
        CriteriaQuery<LogroEntidad> criteriaQuery = criteriaBuilder.createQuery(LogroEntidad.class);
        // Creamos una instancia del tipo Root para representar la entidad principal.
        Root<LogroEntidad> root = criteriaQuery.from(LogroEntidad.class);
        
        // Mediante el método select(), se especifica que la consulta obtendrá
        // todos los campos de LogroEntidad.
        criteriaQuery.select(root);
        // A la consulta le añadimos una cláusula WHERE donde indicamos que sólo
        // se obtengan los logros con una puntuación mayor a 10.
        criteriaQuery.where(criteriaBuilder.greaterThan(root.get("puntuacion"), 10));

        // Se manda a ejecutar la consulta y se obtiene una lista con los resultados.
        List<LogroEntidad> results = em.createQuery(criteriaQuery).getResultList();
        
        return results;
    }
}
