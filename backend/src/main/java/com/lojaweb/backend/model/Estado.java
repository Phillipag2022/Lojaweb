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
import lombok.Data;

@Entity(name="Estado")
@Table(name="Estado")
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String sigla;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriaçao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
