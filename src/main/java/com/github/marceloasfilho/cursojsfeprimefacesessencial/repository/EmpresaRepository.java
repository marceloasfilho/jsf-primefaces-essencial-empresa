package com.github.marceloasfilho.cursojsfeprimefacesessencial.repository;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.Empresa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class EmpresaRepository implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager entityManager;

    public Empresa findById(Long id) {
        return this.entityManager.find(Empresa.class, id);
    }

    public List<Empresa> findAllByName(String nome) {
        TypedQuery<Empresa> query = this.entityManager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", nome.concat("%"));
        return query.getResultList();
    }

    public List<Empresa> findAll() {
        TypedQuery<Empresa> query = this.entityManager.createQuery("from Empresa", Empresa.class);
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
