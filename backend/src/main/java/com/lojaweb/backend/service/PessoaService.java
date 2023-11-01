package com.lojaweb.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.lojaweb.backend.model.Pessoa;
import com.lojaweb.backend.repository.PessoaRepository;

import jakarta.validation.Valid;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }

    public ResponseEntity<Pessoa> salvaPessoa(@RequestBody @Valid Pessoa pessoa){
        pessoa.setDataCriaçao(new Date());
        Pessoa novaPessoa = this.pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(novaPessoa, HttpStatus.CREATED);

    }

    public ResponseEntity<Pessoa> alteraPessoa(@RequestBody @Valid Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        return new ResponseEntity<Pessoa>(pessoaRepository.save(pessoa), HttpStatus.OK);
    }
    
    public void deletaPessoa(Long id){
        Pessoa idPesssoa = this.pessoaRepository.findById(id).get();
        pessoaRepository.delete(idPesssoa);
    }
}
