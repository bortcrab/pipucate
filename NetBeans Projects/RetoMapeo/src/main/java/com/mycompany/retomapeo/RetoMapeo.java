/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.retomapeo;

import entidades.AstronautaEntidad;
import entidades.AstronautaNaveEntidad;
import entidades.MuerteEntidad;
import entidades.NaveEntidad;
import entidades.VueloEntidad;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase principal del reto en clase.
 * 
 * @author Diego Valenzuela Parra
 */
public class RetoMapeo {

    public static void main(String[] args) {
        // INSERCIONES
        // Creamos el entity manager factory.
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        // Creamos el entity manager.
        EntityManager entityManager = managerFactory.createEntityManager();
        
//        // Iniciamos la transacción.
//        entityManager.getTransaction().begin();
//
//        // Creamos los astronautas.
//        AstronautaEntidad astronauta1 = new AstronautaEntidad("Pipucate", "Pepihuate", "Bepis", "A+", 19, "Masculino", new ArrayList<>());
//        AstronautaEntidad astronauta2 = new AstronautaEntidad("Ambrose", "Kenny", "Smith", "B-", 35, "Masculino", new MuerteEntidad(), new ArrayList<>());
//        
//        // Creamos una instancia de fecha.
//        Calendar fecha = new GregorianCalendar(2024, 2, 29, 4, 24, 55);
//        // Matamos al astronauta 2. :(
//        MuerteEntidad muerte = new MuerteEntidad(fecha, astronauta2);
//        
//        // Creamos la nave.
//        NaveEntidad nave = new NaveEntidad("Pipucatoncia 3000", "Moradito", "Islandia", 50, "Grandota", new ArrayList<VueloEntidad>(), new ArrayList<AstronautaNaveEntidad>());
//        
//        // Creamos los 5 vuelos.
//        Calendar fecha1 = new GregorianCalendar(2023, 5, 20, 12, 45, 59);
//        VueloEntidad vuelo1 = new VueloEntidad(37, fecha1, nave);
//        
//        Calendar fecha2 = new GregorianCalendar(2023, 7, 16, 22, 20, 31);
//        VueloEntidad vuelo2 = new VueloEntidad(45, fecha2, nave);
//        
//        Calendar fecha3 = new GregorianCalendar(2023, 10, 9, 15, 18, 26);
//        VueloEntidad vuelo3 = new VueloEntidad(5, fecha3, nave);
//        
//        Calendar fecha4 = new GregorianCalendar(2023, 10, 30, 19, 30, 12);
//        VueloEntidad vuelo4 = new VueloEntidad(10, fecha4, nave);
//        
//        Calendar fecha5 = new GregorianCalendar(2023, 11, 26, 7, 10, 40);
//        VueloEntidad vuelo5 = new VueloEntidad(2, fecha5, nave);
//
//        // Los metemos a una lista de vuelos.
//        List<VueloEntidad> listaVuelos = new ArrayList<>();
//        listaVuelos.add(vuelo1);
//        listaVuelos.add(vuelo2);
//        listaVuelos.add(vuelo3);
//        listaVuelos.add(vuelo4);
//        listaVuelos.add(vuelo5);
//        
//        // A la nave le asignamos la lista de vuelos.
//        nave.setVuelos(listaVuelos);
//        
//        // Indicamos qué naves pilotea cada astronauta.
//        AstronautaNaveEntidad astroNave1 = new AstronautaNaveEntidad(astronauta1, nave);
//        AstronautaNaveEntidad astroNave2 = new AstronautaNaveEntidad(astronauta2, nave);
//        
//        // Mandamos a persistir la nave.
//        entityManager.persist(nave);
//        // Hacemos el commit.
//        entityManager.getTransaction().commit();
//        
//        System.out.println("Todo correcto\n");
//        
//        // CONSULTA
//        // Construimos una instancia de CriteriaBuilder.
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        // Creamos un objeto CriteriaQuery.
//        CriteriaQuery<VueloEntidad> criteriaQuery = criteriaBuilder.createQuery(VueloEntidad.class);
//        // Creamos una instancia instanciadel tipo Root para representar la entidad
//        // principal de la consulta.
//        Root<VueloEntidad> root = criteriaQuery.from(VueloEntidad.class);
//        
//        // Mediante el método select(), se especifica que la consulta seleccionará
//        // todos los campos de VueloEntidad.
//        criteriaQuery.select(root);
//        
//        // Ordenamos los resultados con base a la fecha y hora de salida de manera
//        // descendente para obtener el último vuelo.
//        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("fechaHoraSalida")));
//
//        // Se manda a ejecutar la consulta, limitamos los resultados a 1 y obtenemos el vuelo.
//        VueloEntidad vuelo = entityManager.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
//        
//        // Obtenemos la fecha y hora de salida del vuelo.
//        Calendar fhs = vuelo.getFechaHoraSalida();
//        String fechaSalida = fhs.get(Calendar.DAY_OF_MONTH)
//                + "/" + (fhs.get(Calendar.MONTH)+1)
//                + "/" + fhs.get(Calendar.YEAR) + " a las "
//                + fhs.get(Calendar.HOUR_OF_DAY) + ":"
//                + fhs.get(Calendar.MINUTE) + ":"
//                + fhs.get(Calendar.SECOND);
//        
//        // Obtenemos los datos importantes de la nave del vuelo.
//        nave = vuelo.getNave();
//        String nombreNave = nave.getNombre();
//        int capacidad = nave.getNumeroPasajero();
//        
//        // Obtenemos los astronautas que pilotaron la nave.
//        astronauta1 = nave.getListaAstronautas().getFirst().getAstronauta();
//        String nombre1 = astronauta1.getNombres() + " " + astronauta1.getApellidoPaterno()+ " " + astronauta1.getApellidoMaterno();
//        
//        astronauta2 = nave.getListaAstronautas().getLast().getAstronauta();
//        String nombre2 = astronauta2.getNombres() + " " + astronauta2.getApellidoPaterno()+ " " + astronauta2.getApellidoMaterno();
//        
//        // Obtenemos la única muerte registrada en la base de datos.
//        String astronautaMuerto;
//        // Como los inserts se hacen de manera aleatoria, hice esto para siempre obtener
//        // al astronauta muerto.
//        if (astronauta1.getMuerte() != null) {
//            muerte = astronauta1.getMuerte();
//            astronautaMuerto = nombre1;
//        } else {
//            muerte = astronauta2.getMuerte();
//            astronautaMuerto = nombre2;
//        }
//        
//        // Obtenemos la fecha y hora de la muerte del astronauta.
//        Calendar fm = muerte.getFechaHora();
//        String fechaMuerte = fm.get(Calendar.DAY_OF_MONTH)
//                + "/" + (fm.get(Calendar.MONTH)+1)
//                + "/" + fm.get(Calendar.YEAR) + " a las "
//                + fm.get(Calendar.HOUR_OF_DAY) + ":"
//                + fm.get(Calendar.MINUTE) + ":"
//                + fm.get(Calendar.SECOND);
//        
//        // Imprimimos.
//        System.out.format("""
//                          CONSULTA:
//                          Los astronautas: %s y %s fueron muy
//                          valientes debido a que se subieron a la %s, que tiene la
//                          capacidad de %d pasajeros, haciendo un vuelo el %s.
//                          Lamentablemente, el astronauta %s perdió la vida el %s.
//                          """,
//                          nombre1, nombre2, nombreNave, capacidad, fechaSalida,
//                          astronautaMuerto, fechaMuerte);
        
        //----CONSULTAS CON CRITERIA QUERY----//
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<AstronautaEntidad> criteriaQuery = criteriaBuilder.createQuery(AstronautaEntidad.class);
        
        Root<AstronautaEntidad> root = criteriaQuery.from(AstronautaEntidad.class);
        
        
        // CONSULTA 1
        criteriaQuery.select(root);
        
        criteriaQuery.where(criteriaBuilder.gt(root.get("edad"), 40));

        List<AstronautaEntidad> astronautas = entityManager.createQuery(criteriaQuery).getResultList();
        
        System.out.println("\nCONSULTA 1 CON CRITERIA QUERY");
        System.out.println("Astronautas mayores de 40:");
        for (AstronautaEntidad astronauta : astronautas) {
            AstronautaDTO astroDTO = new AstronautaDTO(astronauta);
            System.out.println(astroDTO);
        }
        
        
        // CONSULTA 2
        criteriaQuery.select(root);
        
        criteriaQuery.where(criteriaBuilder.equal(root.get("sexo"), "Femenino"));

        astronautas = entityManager.createQuery(criteriaQuery).getResultList();
        
        System.out.println("\nCONSULTA 2 CON CRITERIA QUERY");
        System.out.println("Astronautas femeninas:");
        for (AstronautaEntidad astronauta : astronautas) {
            AstronautaDTO astroDTO = new AstronautaDTO(astronauta);
            System.out.println(astroDTO);
        }
        
        //----CONSULTAS CON JPQL----//
        // CONSULTA 1
        String consulta = """
                          SELECT a
                          FROM AstronautaEntidad a
                          WHERE a.edad > :edad
                          """;

        TypedQuery<AstronautaEntidad> query = entityManager.createQuery(consulta, AstronautaEntidad.class);
        
        query.setParameter("edad", 40);
        
        astronautas = query.getResultList();
        
        System.out.println("\nCONSULTA 1 CON JPQL");
        System.out.println("Astronautas mayores de 40:");
        for (AstronautaEntidad astronauta : astronautas) {
            AstronautaDTO astroDTO = new AstronautaDTO(astronauta);
            System.out.println(astroDTO);
        }
        
        
        // CONSULTA 2
        consulta = """
                   SELECT a
                   FROM AstronautaEntidad a
                   WHERE a.sexo = :sexo
                   """;

        query = entityManager.createQuery(consulta, AstronautaEntidad.class);
        
        query.setParameter("sexo", "Femenino");
        
        astronautas = query.getResultList();
        
        System.out.println("\nCONSULTA 2 CON JPQL");
        System.out.println("Astronautas femeninas:");
        for (AstronautaEntidad astronauta : astronautas) {
            AstronautaDTO astroDTO = new AstronautaDTO(astronauta);
            System.out.println(astroDTO);
        }

        // CONSULTA 3
        // Ejemplo con group by
        consulta = """
                   SELECT NEW com.mycompany.retomapeo.SexoDTO(a.sexo, COUNT(a))
                   FROM AstronautaEntidad a
                   GROUP BY a.sexo
                   """;
        
        TypedQuery<SexoDTO> tQuery = entityManager.createQuery(consulta, SexoDTO.class);
        
        List<SexoDTO> results = tQuery.getResultList();
        
        System.out.println("\nCONSULTA 3 CON JPQL");
        System.out.println("Cantidad de astronautas por sexo:");
        for (SexoDTO result : results) {
            
            System.out.println(result);
        }
        
        // Ejemplo de GROUP BY con CriteriaQuery
        System.out.println("\nConsulta GROUP BY con CriteriaQuery");
        CriteriaBuilder cbd = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cbd.createQuery();
        Root<AstronautaEntidad> raiz3 = cq.from(AstronautaEntidad.class);
        cq.select(cbd.construct(SexoDTO.class, 
                raiz3.get("sexo"), 
                cbd.count(raiz3)));
        cq.groupBy(raiz3.get("sexo"));
        TypedQuery<SexoDTO> consultaTipada = entityManager.createQuery(cq);
        List<SexoDTO> sexos = consultaTipada.getResultList();
        
        System.out.println("\nCONSULTA 3 CON CRITERIA QUERY");
        System.out.println("Cantidad de astronautas por sexo:");
        for (SexoDTO sexo : sexos) {
            System.out.println(sexo);
        }
        
        // Cerramos el entity manager y la fábrica.
        entityManager.close();
        managerFactory.close();
    }
}
