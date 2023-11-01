package com.lojaweb.backend.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name="Produto")
@Table(name="Produto")
@Data
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descricaoCurta;

    @NotBlank
    private String descricaoDetalhada;

    @NotBlank
    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria;

    @NotBlank
    @ManyToOne
    @JoinColumn(name="idMarca")
    private Marca marca;

    @NotBlank
    private Float valorCusto;

    @NotBlank
    private Float valorVenda;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;


}
