package com.lojaweb.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaweb.backend.model.Produto;
import com.lojaweb.backend.service.ProdutoService;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> listaTodos(){
        return produtoService.listaTodos();
    }
    @PostMapping("/")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto){
        return produtoService.salvaProduta(produto);
    }
    @PutMapping("/")
    public ResponseEntity<Produto> alteraProduto(@RequestBody Produto produto){
        return produtoService.alteraProduto(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProduto(@PathVariable("id")Long id){
        produtoService.deletaProduto(id);
        return ResponseEntity.ok().build();
    }
}
