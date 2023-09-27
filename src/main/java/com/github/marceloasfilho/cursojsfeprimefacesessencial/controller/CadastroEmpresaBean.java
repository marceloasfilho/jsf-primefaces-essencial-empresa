package com.github.marceloasfilho.cursojsfeprimefacesessencial.controller;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.Empresa;
import com.github.marceloasfilho.cursojsfeprimefacesessencial.repository.EmpresaRepository;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Named
@ViewScoped
public class CadastroEmpresaBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private EmpresaRepository empresaRepository;

    private List<Empresa> todasEmpresas;

    public void todasEmpresas() {
        this.todasEmpresas = this.empresaRepository.findAll();
    }
}
