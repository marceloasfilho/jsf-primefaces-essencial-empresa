package com.github.marceloasfilho.cursojsfeprimefacesessencial.repository;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class SchemaGeneration {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Empresa> lista = entityManager.createQuery("FROM Empresa", Empresa.class).getResultList();
        System.out.println(lista);
        entityManager.close();
        entityManagerFactory.close();
    }
}
