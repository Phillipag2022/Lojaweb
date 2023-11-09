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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lojaweb.backend.model.ProdutoImagens;
import com.lojaweb.backend.service.ProdutoImagensService;

@RestController
@RequestMapping("api/produtoImagens")
public class ProdutoImagensController {
     @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/")
    public List<ProdutoImagens> listaTodas(){
        return produtoImagensService.listaTodos();
    }
    @PostMapping("/")
    public ResponseEntity<ProdutoImagens> salvaProdutoImagem(@RequestBody @RequestParam("idProduto") Long idProduto ,@RequestParam("file")MultipartFile file ){
        return produtoImagensService.salvaProdutoImagens(idProduto,file);
    }
    @PutMapping("/")
    public ResponseEntity<ProdutoImagens> alteraProduto(@RequestBody ProdutoImagens produtoImagens){
        return produtoImagensService.alteraProdutoImagens(produtoImagens);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProduto(@PathVariable("id") Long id){
        produtoImagensService.deletaProdutoImagens(id);   
        return ResponseEntity.ok().build();
     }
}
