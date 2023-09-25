package com.github.marceloasfilho.cursojsfeprimefacesessencial.controller;

import com.github.marceloasfilho.cursojsfeprimefacesessencial.enums.TipoEmpresa;
import com.github.marceloasfilho.cursojsfeprimefacesessencial.model.Empresa;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private Empresa empresa;

    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }

    public void salvar() {
        System.out.println("Razão Social: " + this.empresa.getRazaoSocial());
    }

    public String ajuda(){
        return "gestao-empresas-ajuda.xhtml?faces-redirect=true";
    }
}
