package com.lojaweb.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lojaweb.backend.model.Produto;
import com.lojaweb.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listaTodos(){
        return produtoRepository.findAll();
    }

    public ResponseEntity<Produto> salvaProduta(Produto produto){
        produto.setDataCriacao(new Date());
        Produto novoProduto = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
    }

    public ResponseEntity<Produto> alteraProduto(Produto produto){
        produto.setDataAtualizacao(new Date());
        return new ResponseEntity<Produto>(produto,HttpStatus.OK);
    }

    public void deletaProduto(Long id){
        Produto produto = this.produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
}
