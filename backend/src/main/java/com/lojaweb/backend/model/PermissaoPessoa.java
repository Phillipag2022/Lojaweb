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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Permissao_Pessoa")
@Table(name="Permissao_Pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissaoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idPessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name="idPermissao")
    private Permissao permissao;

   
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}