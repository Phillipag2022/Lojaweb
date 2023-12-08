package com.lojaweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaweb.backend.model.PermissaoPessoa;

@Repository
public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa,Long> {
   
}
