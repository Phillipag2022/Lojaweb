package com.lojaweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojaweb.backend.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    
}
