/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplojpa;

import entidades.CarroEntidad;
import java.util.List;
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
        
        for (int i = 0; i < 9; i++) {
            System.out.println("Carro " + (i+2) + ": " + carros.get(i).getNombre());
        }
        
        //CERRAMOS
        entityManager.close();
        managerFactory.close();
    }
}
