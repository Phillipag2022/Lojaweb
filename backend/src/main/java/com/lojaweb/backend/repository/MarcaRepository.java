package com.lojaweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaweb.backend.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {
    
}
