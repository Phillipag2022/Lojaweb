package com.lojaweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaweb.backend.model.Pessoa;



@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    
    Pessoa findByEmail(String email);

    Pessoa findByEmailAndCodigoRecuperaçaoSenha(String email, String odigoRecuperaçaoSenha);
}
