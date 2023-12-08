package com.lojaweb.backend.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity(name="Permissao_Pessoa")
@Table(name="Permissao_Pessoa")
@Data
public class PermissaoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idPessoa")
    @JsonIgnore
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name="idPermissao")
    private Permissao permissao;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}