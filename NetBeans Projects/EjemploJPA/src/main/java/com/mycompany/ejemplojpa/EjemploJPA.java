/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejemplojpa;

import daos.JuegoDAO;
import daos.JugadorDAO;
import daos.LogroDAO;
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
import javax.persistence.criteria.*;

/**
 *
 * @author bortc
 */
public class EjemploJPA {

    public static void main(String[] args) {
////        ////////////////////////////////////////////////////////////////////////
////        //EJEMPLO CON CARROS                                                  //
////        ////////////////////////////////////////////////////////////////////////
////
////        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
////        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
////        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
////        EntityManager entityManager = managerFactory.createEntityManager();
////
////        /**
////         * INSERTAR CARROS
////         */
////        //INICIAMOS LA TRANSACCION
////        entityManager.getTransaction().begin();
////
////        for (int i = 0; i < 10; i++) {
////            CarroEntidad entidad = new CarroEntidad("Carro número " + (i + 1));
////            entityManager.persist(entidad);
////        }
////
////        //MANDAMOS A EJECUTAR LA TRANSACCION
////        entityManager.getTransaction().commit();
////        System.out.println("Se insertaron los carros.");
////
////        /**
////         * BUSCAR CARRO
////         */
////        CarroEntidad carro = entityManager.find(CarroEntidad.class, 7L);
////        System.out.println("Carro encontrado: " + carro.getNombre());
////
////        /**
////         * MODIFICAR CARRO
////         */
////        entityManager.getTransaction().begin();
////        carro.setNombre("Honda");
////
////        entityManager.merge(carro);
////
////        //MANDAMOS A EJECUTAR LA TRANSACCION
////        entityManager.getTransaction().commit();
////        System.out.println("Se modificaron los datos del carro 7.");
////
////        /**
////         * ELIMINAR CARRO
////         */
////        carro = entityManager.find(CarroEntidad.class, 1L);
////        System.out.println("Carro a eliminar: " + carro.getNombre());
////
////        entityManager.getTransaction().begin();
////
////        entityManager.remove(carro);
////
////        //MANDAMOS A EJECUTAR LA TRANSACCION
////        entityManager.getTransaction().commit();
////        System.out.println("Se eliminó: " + carro.getNombre());
////
////        // Primero, gracias al entity manager, construimos una instancia de
////        // CriteriaBuilder.
////        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
////        // Creamos un objeto CriteriaQuery para construir una consulta de criterios
////        // para la entidad carro.
////        CriteriaQuery<CarroEntidad> criteriaQuery = criteriaBuilder.createQuery(CarroEntidad.class);
////        // Creamos una instancia del tipo Root para representar la entidad principal
////        // de la consulta (en este caso CarroEntidad).
////        Root<CarroEntidad> root = criteriaQuery.from(CarroEntidad.class);
////        // Mediante el método select(), se especifica que la consulta seleccionará
////        // todos los campos de CarroEntidad.
////        criteriaQuery.select(root);
////
////        // Se manda a ejecutar la consulta y se obtiene una lista con los resultados.
////        List<CarroEntidad> results = entityManager.createQuery(criteriaQuery).getResultList();
////        
////        // Finalmente, sólo se itera sobre los resultados para imprimir en consola
////        // los nombres de los carros.
////        System.out.println("Lista de carros:");
////        for (CarroEntidad result : results) {
////            System.out.println(result.getNombre());
////        }
//
////        // Definimos la consulta a realizar, en este caso, seleccionar todos los
////        // registros de CarroEntidad ordenados ascendentemente según el nombre.
////        String jpql = "SELECT c FROM CarroEntidad c "
////                    + "ORDER BY c.nombre ASC";
////        // Guardamos en una lista los resultados de la consulta.
////        List<CarroEntidad> results = entityManager.createQuery(jpql, CarroEntidad.class).getResultList();
////        
////        // Finalmente, sólo se itera sobre los resultados para imprimir en consola
////        // los nombres de los carros.
////        System.out.println("Lista de carros:");
////        for (CarroEntidad result : results) {
////            System.out.println(result.getNombre());
////        }
//
//        ////////////////////////////////////////////////////////////////////////
//        //EJEMPLO CON VIDEOJUEGOS                                             //
//        ////////////////////////////////////////////////////////////////////////
//        /**
//         * INSERTAR JUEGOS Y LOGROS
//         */
//        // Creamos una lista y le añadimos dos logros.
//        List<LogroEntidad> listaLogros1 = new ArrayList<>();
//        listaLogros1.add(new LogroEntidad("Gana una partida", 50));
//        listaLogros1.add(new LogroEntidad("Gana dos partidas", 100));
//
//        // Creamos un juego con la lista de logros.
//        JuegoEntidad juego1 = new JuegoEntidad("Evil Mojo", "Paladins", new GregorianCalendar(2018, 4, 8), listaLogros1, new HashSet<>());
//        juego1.setId(1L);
//
//        /*
//        // Creamos un objeto para manejar el acceso a datos de los juegos.
//        JuegoDAO juegoDAO = new JuegoDAO();
//        // Mandamos a guardar el juego.
//        juegoDAO.guardar(juego);
//        */
//        
//        // Vaciamos la lista de logros para meterle dos logros nuevos.
//        List<LogroEntidad> listaLogros2 = new ArrayList<>();
//        listaLogros2.add(new LogroEntidad("Desbloquea a Smoke", 100));
//        listaLogros2.add(new LogroEntidad("Desbloquea a Jade", 200));
//
//        // Creamos otro juego con la nueva lista.
//        JuegoEntidad juego2 = new JuegoEntidad("NetherRealm Studios", "Mortal Kombat", new GregorianCalendar(2022, 0, 15), listaLogros2, new HashSet<>());
//
////        // Mandamos a guardar el nuevo juego.
////        juegoDAO.guardar(juegoNuevo);
//
//        /**
//         * INSERTAR JUGADOR Y DIRECCIÓN
//         */
//        // Creamos un set de juegos y añadimos los que creamos.
//        Set<JuegoEntidad> listaJuegos = new HashSet<>();
//        listaJuegos.add(juego1);
//        listaJuegos.add(juego2);
//
//        // Creamos una fecha de nacimiento y una dirección para nuestro jugador.
//        Calendar fechaNacimiento = new GregorianCalendar(2004, 5, 3); // Lo que pongamos de mes saldrá más 1.
//        DireccionEntidad direccion = new DireccionEntidad("Río Nilo", "Girasoles", "888");
//        // Creamos el jugador con todos sus atributos.
//        JugadorEntidad jugador = new JugadorEntidad("Pipucate", Sexo.Hombre, fechaNacimiento, direccion, listaJuegos);
//
//        // Creamos un objeto para manejar el acceso a datos de los jugadores.
//        JugadorDAO jugadorDAO = new JugadorDAO();
//        // Mandamos a guardar al jugador.
//        jugadorDAO.guardar(jugador);
//
////        /**
////         * MODIFICAR JUEGO
////         */
////        // Obtenemos un juego de la base de datos.
////        JuegoEntidad juegoEditar = juegoDAO.obtenerPorID(1L);
////
////        // Cambiamos los datos del juego.
////        juegoEditar.setDesarrolladora("Mason Lindroth");
////        juegoEditar.setNombre("Hylics 2");
////
////        // Mandamos el juego a editar.
////        juegoDAO.editar(juegoEditar);
//
////        /**
////         * ELIMINAR JUEGO
////         */
////        // Mandamos un juego a eliminar.
////        juegoDAO.eliminar(juegoNuevo); // En este caso estoy mandando a eliminar
////                                       // el Mortal Kombat.
//
////        /**
////         * CONSULTAS DE LA ACTIVIDAD 13
////         */
////        // Se obtiene la lista de juegos con Mario.
////        List<JuegoEntidad> juegosMario = juegoDAO.consultarMario();
////        
////        // Se itera sobre cada elemento de la lista y se imprimen sus datos.
////        System.out.print("Juegos con 'Mario' en el nombre:");
////        for (JuegoEntidad juegoMario : juegosMario) {
////            System.out.print("\nNombre: " + juegoMario.getNombre());
////        }
////        
////        // Creamos un objeto de tipo LogroDAO.
////        LogroDAO logroDAO = new LogroDAO();
////        
////        // Se obtiene la lista de juegos con Mario.
////        List<LogroEntidad> logrosDiez = logroDAO.consultarPuntos();
////        
////        // Se itera sobre cada elemento de la lista y se imprimen sus datos.
////        System.out.print("Logros con premios mayores a 10 puntos:");
////        for (LogroEntidad logroDiez : logrosDiez) {
////            System.out.print("\nJuego: " + logroDiez.getJuego().getNombre() +
////                             ", Logro: " + logroDiez.getNombre() +
////                             ", Puntuación: " + logroDiez.getPuntuacion());
////        }
////        
////        
////        // Se obtiene la lista de juegos lanzados en enero de 2022.
////        List<JuegoEntidad> juegosEnero = juegoDAO.consultarEnero();
////
////        // Se itera sobre cada elemento de la lista y se imprimen sus datos.
////        System.out.print("Juegos lanzados en enero de 2022:");
////        for (JuegoEntidad juegoEnero : juegosEnero) {
////            System.out.print("\nNombre: " + juegoEnero.getNombre() +
////                               ", Fecha de lanzamiento: " + juegoEnero.getLanzamiento().getTime());
////        }
////        
////        // Primero, gracias al entity manager, construimos una instancia de
////        // CriteriaBuilder.
////        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
////        // Creamos un objeto CriteriaQuery para construir una consulta de criterios
////        // para la entidad jugador.
////        CriteriaQuery<JugadorEntidad> criteriaQuery = criteriaBuilder.createQuery(JugadorEntidad.class);
////        // Creamos una instancia del tipo Root para representar la entidad principal
////        // de la consulta (en este caso JugadorEntidad).
////        Root<JugadorEntidad> root = criteriaQuery.from(JugadorEntidad.class);
////        // Mediante el método select(), se especifica que la consulta seleccionará
////        // todos los campos de JugadorEntidad.
////        criteriaQuery.select(root);
////        // A la consulta le añadimos una cláusula WHERE donde indicamos que sólo
////        // se obtengan los registros donde la fecha de nacimiento sea anterior al
////        // 3 de junio de 2005.
////        criteriaQuery.where(criteriaBuilder.lessThan(root.get("fechaNacimiento"), new GregorianCalendar(2005, 05, 03)));
////
////        // Se manda a ejecutar la consulta y se obtiene una lista con los resultados.
////        List<JugadorEntidad> results = entityManager.createQuery(criteriaQuery).getResultList();
////        
////        // Finalmente, sólo se itera sobre los resultados para imprimir en consola
////        // los pseudónimos de los jugadores y su fecha de nacimiento.
////        System.out.println("Lista de jugadores:");
////        for (JugadorEntidad result : results) {
////            System.out.println(result.getPseudonimo() + ", " + result.getFechaNacimiento().getTime());
////        }
//
////        // Primero, gracias al entity manager, construimos una instancia de
////        // CriteriaBuilder.
////        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
////        // Creamos un objeto CriteriaQuery para construir una consulta de criterios
////        // para la entidad logro.
////        CriteriaQuery<LogroEntidad> criteriaQuery = criteriaBuilder.createQuery(LogroEntidad.class);
////        // Creamos una instancia del tipo Root para representar la entidad principal
////        // de la consulta (en este caso LogroEntidad).
////        Root<LogroEntidad> root = criteriaQuery.from(LogroEntidad.class);
////        // Mediante el método select(), se especifica que la consulta seleccionará
////        // todos los campos de LogroEntidad.
////        criteriaQuery.select(root);
////        // A la consulta le añadimos una cláusula WHERE donde indicamos que sólo
////        // se obtengan los registros donde la puntuación del logro sea mayor a 80.
////        criteriaQuery.where(criteriaBuilder.greaterThan(root.get("puntuacion"), 80));
////
////        // Se manda a ejecutar la consulta y se obtiene una lista con los resultados.
////        List<LogroEntidad> results = entityManager.createQuery(criteriaQuery).getResultList();
////        
////        // Finalmente, sólo se itera sobre los resultados para imprimir en consola
////        // los datos de los logros.
////        System.out.print("Lista de logros:");
////        for (LogroEntidad result : results) {
////            System.out.println("\nJuego: " + result.getJuego().getNombre() +
////                    ", Logro: " + result.getNombre() +
////                    ", Puntuación: " + result.getPuntuacion());
////        }
//
////        // Definimos la consulta a realizar, en este caso, obtener el número de logros
////        // de cada juego.
////        String jpql = "SELECT COUNT(l), l.juego "
////                + "FROM LogroEntidad l "
////                + "GROUP BY l.juego";
////        // Guardamos en una lista los resultados de la consulta.
////        List<Object[]> results = entityManager.createQuery(jpql).getResultList();
////
////        // Finalmente, sólo se itera sobre los resultados para imprimir en consola los
////        // juegos y su cantidad de logros.
////        System.out.println("Lista de juegos y sus logros:");
////        for (Object[] result : results) {
////            Long count = (Long) result[0];
////            JuegoEntidad juego = (JuegoEntidad) result[1];
////            System.out.println("Juego: " + juego.getNombre() + ", número de logros: " + count);
////        }
//
////        entityManager.close();
////        managerFactory.close();
    }
}
