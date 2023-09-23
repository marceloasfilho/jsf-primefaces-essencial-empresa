package com.github.marceloasfilho.cursojsfeprimefacesessencial.repository;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public class EmpresaRepository implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final EntityManager entityManager;

    public Empresa findById(Long id) {
        return this.entityManager.find(Empresa.class, id);
    }

    public List<Empresa> findAll(String nome) {
        TypedQuery<Empresa> query = this.entityManager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", nome.concat("%"));
        return query.getResultList();
    }

    public Empresa save(Empresa empresa) {
        return this.entityManager.merge(empresa);
    }

    public void delete(Empresa empresa) {
        Empresa empresaById = this.findById(empresa.getId());
        this.entityManager.remove(empresaById);
    }
}
