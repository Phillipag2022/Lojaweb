package com.lojaweb.backend.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.lojaweb.backend.model.Cidade;
import com.lojaweb.backend.repository.CidadeRepository;
import jakarta.validation.Valid;

@Service
public class CidadeService {

    @Autowired
   private CidadeRepository cidadeRepository;

   public List<Cidade> listarTodos(){
    return cidadeRepository.findAll();
   }

   public ResponseEntity<Cidade> salvaCidade(@RequestBody @Valid Cidade cidade){
    cidade.setDataCriaçao(new Date());
    Cidade novaCidade = this.cidadeRepository.save(cidade);
    return new ResponseEntity<>(novaCidade, HttpStatus.CREATED);
   }

   public ResponseEntity<Cidade> alteraCidade(@RequestBody @Valid Cidade cidade){
    cidade.setDataAtualizacao(new Date());
    return new ResponseEntity<>(cidadeRepository.save(cidade),HttpStatus.OK);
   }

   public void deletaCidade(Long id){
        Cidade idCidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(idCidade);
       }
}
