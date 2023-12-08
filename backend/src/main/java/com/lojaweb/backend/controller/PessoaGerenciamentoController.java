package com.lojaweb.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.lojaweb.backend.model.Pessoa;
import com.lojaweb.backend.service.PessoaGerenciamentoService;

@RestController
@RequestMapping("api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {
    
    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/senha-codigo")
    public ResponseEntity<String> recuperarCodigo(@RequestBody Pessoa pessoa){
        return pessoaGerenciamentoService.solicitarCodigo(pessoa.getEmail());
    
    }

    @PostMapping("/senha-alterar")
    public ResponseEntity<String> alterarSenha(@RequestBody Pessoa pessoa){
        return pessoaGerenciamentoService.alterarSenha(pessoa);
    }
    
}
