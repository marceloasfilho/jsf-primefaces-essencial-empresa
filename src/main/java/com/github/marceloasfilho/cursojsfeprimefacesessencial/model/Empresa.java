package com.github.marceloasfilho.cursojsfeprimefacesessencial.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.marceloasfilho.cursojsfeprimefacesessencial.enums.TipoEmpresa;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "razao_social")
    private String razaoSocial;
    private String cnpj;
    @Column(name = "dataFundacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDate dataFundacao;
    @ManyToOne
    @JoinColumn(name = "ramo_atividade_id")
    private RamoAtividade ramoAtividade;
}
