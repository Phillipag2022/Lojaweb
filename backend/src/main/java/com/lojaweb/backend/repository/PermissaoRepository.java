package com.lojaweb.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojaweb.backend.model.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Long> {
    List<Permissao> findByNome(String nome);
}
