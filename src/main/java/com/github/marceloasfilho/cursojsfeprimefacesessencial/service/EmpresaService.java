package com.github.marceloasfilho.cursojsfeprimefacesessencial.service;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.Empresa;
import com.github.marceloasfilho.cursojsfeprimefacesessencial.repository.EmpresaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.Serial;
import java.io.Serializable;

public class EmpresaService implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresaRepository empresaRepository;

    @Transactional
    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    public void delete(Empresa empresa) {
        this.empresaRepository.delete(empresa);
    }

}
