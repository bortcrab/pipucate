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

/**
 *
 * @author EP
 */
public class RetoMapeo {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //Creamos la entidad
        AstronautaEntidad astronauta1 = new AstronautaEntidad("Pipucate", "Valenzuela", "Parra", "A+", 19, "Hombre", new ArrayList<>());
        AstronautaEntidad astronauta2 = new AstronautaEntidad("Ambrose", "Kenny", "Smith", "B-", 35, "Hombre", new MuerteEntidad(), new ArrayList<>());
        
        Calendar fecha = Calendar.getInstance();
        MuerteEntidad muerte = new MuerteEntidad(fecha, astronauta2);
        
        NaveEntidad nave = new NaveEntidad("Pipucatoncia 3000 1.0", "Moradito", "Islandia", 50, "Grandota", new ArrayList<VueloEntidad>(), new ArrayList<AstronautaNaveEntidad>());
        
        Calendar fecha1 = new GregorianCalendar(2024, 2, 20);
        VueloEntidad vuelo1 = new VueloEntidad(1, fecha1, nave);
        
        Calendar fecha2 = new GregorianCalendar(2024, 1, 16);
        VueloEntidad vuelo2 = new VueloEntidad(1, fecha2, nave);
        
        Calendar fecha3 = new GregorianCalendar(2024, 10, 9);
        VueloEntidad vuelo3 = new VueloEntidad(1, fecha3, nave);
        
        Calendar fecha4 = new GregorianCalendar(2024, 3, 30);
        VueloEntidad vuelo4 = new VueloEntidad(1, fecha4, nave);
        
        Calendar fecha5 = new GregorianCalendar(2023, 1,26);
        VueloEntidad vuelo5 = new VueloEntidad(1, fecha5, nave);

        List<VueloEntidad> listaVuelos = new ArrayList<>();
        listaVuelos.add(vuelo1);
        listaVuelos.add(vuelo2);
        listaVuelos.add(vuelo3);
        listaVuelos.add(vuelo4);
        listaVuelos.add(vuelo5);
        
        nave.setVuelos(listaVuelos);
        
        AstronautaNaveEntidad astroNave1 = new AstronautaNaveEntidad(astronauta1, nave);
        AstronautaNaveEntidad astroNave2 = new AstronautaNaveEntidad(astronauta2, nave);
        
        entityManager.persist(astronauta2);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
        
        System.out.println("Todo correcto");

    }
}
