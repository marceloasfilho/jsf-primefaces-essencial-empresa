package com.github.marceloasfilho.cursojsfeprimefacesessencial.repository;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.RamoAtividade;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class RamoAtividadeRepository implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public List<RamoAtividade> findByDescricao(String descricao) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> query = criteriaBuilder.createQuery(RamoAtividade.class);
        Root<RamoAtividade> root = query.from(RamoAtividade.class);
        query.select(root);
        query.where(criteriaBuilder.like(root.get("descricao"), descricao.concat("%")));
        TypedQuery<RamoAtividade> finalQuery = this.entityManager.createQuery(query);
        return finalQuery.getResultList();
    }
}
