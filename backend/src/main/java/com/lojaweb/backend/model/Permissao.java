package com.lojaweb.backend.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Permissao")
@Table(name="Permissao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
