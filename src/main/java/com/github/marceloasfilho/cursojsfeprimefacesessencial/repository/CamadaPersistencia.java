package com.github.marceloasfilho.cursojsfeprimefacesessencial.repository;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.Empresa;
import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.RamoAtividade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CamadaPersistencia {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Declarando repositórios
        RamoAtividadeRepository ramoAtividadeRepository = new RamoAtividadeRepository(entityManager);
        EmpresaRepository empresaRepository = new EmpresaRepository(entityManager);

        // Buscando as informações no banco
        List<RamoAtividade> ramosAtividadesPorDescricao = ramoAtividadeRepository.findByDescricao("Telecomunicação");
        List<Empresa> todasEmpresasPorNome = empresaRepository.findAll("Maria");
        System.out.println(ramosAtividadesPorDescricao);
        System.out.println(todasEmpresasPorNome);
    }
}
