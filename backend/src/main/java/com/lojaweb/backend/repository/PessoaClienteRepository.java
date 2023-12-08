package com.lojaweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaweb.backend.model.Pessoa;

@Repository
public interface PessoaClienteRepository extends JpaRepository<Pessoa,Long> {

    
    
}
