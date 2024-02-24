/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplojpa;

import daos.JuegoDAO;
import daos.JugadorDAO;
import entidades.CarroEntidad;
import entidades.DireccionEntidad;
import entidades.JuegoEntidad;
import entidades.JugadorEntidad;
import entidades.LogroEntidad;
import entidades.Sexo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author bortc
 */
public class EjemploJPA {

    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////////////
        //EJEMPLO CON CARROS                                                  //
        ////////////////////////////////////////////////////////////////////////
        
        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
        EntityManager entityManager = managerFactory.createEntityManager();
        
        /**
         * INSERTAR CARROS
         */
        //INICIAMOS LA TRANSACCION
        entityManager.getTransaction().begin();
        
        for (int i = 0; i < 10; i++) {
            CarroEntidad entidad = new CarroEntidad("Carro número " + (i+1));
            entityManager.persist(entidad);
        }

        //MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();
        System.out.println("Se insertaron los carros.");
        
        /**
         * BUSCAR CARRO
         */
        CarroEntidad carro = entityManager.find(CarroEntidad.class, 7L);
        System.out.println("Carro encontrado: " + carro.getNombre());
        
        /**
         * MODIFICAR CARRO
         */
        entityManager.getTransaction().begin();
        carro.setNombre("Honda");
        
        entityManager.merge(carro);

        //MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();
        System.out.println("Se modificaron los datos del carro 7.");

        /**
         * ELIMINAR CARRO
         */
        carro = entityManager.find(CarroEntidad.class, 1L);
        System.out.println("Carro a eliminar: " + carro.getNombre());

        entityManager.getTransaction().begin();
        
        entityManager.remove(carro);

        //MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();
        System.out.println("Se eliminó: " + carro.getNombre());
        
        TypedQuery<CarroEntidad> query = entityManager.createQuery("SELECT c FROM CarroEntidad c", CarroEntidad.class);
        
        List<CarroEntidad> carros = query.getResultList();
        
        for (int i = 0; i < carros.size(); i++) {
            System.out.println("Carro " + (i+2) + ": " + carros.get(i).getNombre());
        }
        
        //CERRAMOS
        entityManager.close();
        managerFactory.close();
            

        
        ////////////////////////////////////////////////////////////////////////
        //EJEMPLO CON VIDEOJUEGOS                                             //
        ////////////////////////////////////////////////////////////////////////
        
        /**
         * INSERTAR JUEGOS Y LOGROS
         */
        // Creamos una lista y le añadimos dos logros.
        List<LogroEntidad> listaLogros = new ArrayList<>();
        listaLogros.add(new LogroEntidad("Gana una partida", "50"));
        listaLogros.add(new LogroEntidad("Gana dos partidas", "100"));
        
        // Creamos un juego con la lista de logros.
        JuegoEntidad juego = new JuegoEntidad("Evil Mojo", "Paladins", listaLogros);
        
        // Creamos un objeto para manejar el acceso a datos de los juegos.
        JuegoDAO juegoDAO = new JuegoDAO();
        // Mandamos a guardar el juego.
        juegoDAO.guardar(juego);
        
        // Vaciamos la lista de logros para meterle dos logros nuevos.
        listaLogros.removeAll(listaLogros);
        listaLogros.add(new LogroEntidad("Desbloquea a Smoke", "100"));
        listaLogros.add(new LogroEntidad("Desbloquea a Jade", "200"));
        
        // Creamos otro juego con la nueva lista.
        JuegoEntidad juegoNuevo = new JuegoEntidad("NetherRealm Studios", "Mortal Kombat", listaLogros);
        
        // Mandamos a guardar el nuevo juego.
        juegoDAO.guardar(juegoNuevo);
        
        /**
         * INSERTAR JUGADOR Y DIRECCIÓN
         */
        // Creamos un set de juegos y añadimos los que creamos.
        Set listaJuegos = new HashSet();
        listaJuegos.add(juego);
        listaJuegos.add(juegoNuevo);
        
        // Creamos una fecha de nacimiento y una dirección para nuestro jugador.
        Calendar fechaNacimiento = new GregorianCalendar(2004, 5, 3); // Lo que pongamos de mes saldrá más 1.
        DireccionEntidad direccion = new DireccionEntidad("Río Nilo", "Girasoles", "888");
        // Creamos el jugador con todos sus atributos.
        JugadorEntidad jugador = new JugadorEntidad("Pipucate", Sexo.Hombre, fechaNacimiento, direccion, listaJuegos);
        
        // Creamos un objeto para manejar el acceso a datos de los jugadores.
        JugadorDAO jugadorDAO = new JugadorDAO();
        // Mandamos a guardar al jugador.
        jugadorDAO.guardar(jugador);
        
        /**
         * MODIFICAR JUEGO
         */
        // Obtenemos un juego de la base de datos.
        JuegoEntidad juegoEditar = juegoDAO.obtenerPorID(1L);
        
        // Cambiamos los datos del juego.
        juegoEditar.setDesarrolladora("Mason Lindroth");
        juegoEditar.setNombre("Hylics 2");
        
        // Mandamos el juego a editar.
        juegoDAO.editar(juegoEditar);
        
        /**
         * ELIMINAR JUEGO
         */
        // Mandamos un juego a eliminar.
        juegoDAO.eliminar(juegoNuevo); // En este caso estoy mandando a eliminar
                                       // el Mortal Kombat.
    }
}
