package com.lojaweb.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaweb.backend.model.ProdutoImagens;


@Repository
public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
    
    
}
