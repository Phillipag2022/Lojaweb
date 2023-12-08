package com.lojaweb.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lojaweb.backend.DTO.PessoaClienteDTO;
import com.lojaweb.backend.model.Pessoa;
import com.lojaweb.backend.service.PessoaClienteService;



@RestController
@RequestMapping("api/cliente")
public class PessoaClienteController {

   

    @Autowired
    private PessoaClienteService pessoaClienteService;

  
    @PostMapping("/")
    public ResponseEntity<Pessoa> salvaPessoa(@RequestBody PessoaClienteDTO pessoa){
        return pessoaClienteService.salvaPessoa(pessoa);
    }
    
}
