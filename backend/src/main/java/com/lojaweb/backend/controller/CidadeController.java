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

import com.lojaweb.backend.model.Cidade;

import com.lojaweb.backend.service.CidadeService;

@RestController
@RequestMapping("api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

   

    @GetMapping("/")
    public List<Cidade> listarTodos(){
        return cidadeService.listarTodos();
    }
    @PostMapping("/")
    public ResponseEntity<Cidade> salvaCidade(@RequestBody Cidade cidade){
       
        return cidadeService.salvaCidade(cidade);
    }
    @PutMapping("/")
    public ResponseEntity<Cidade> alteraCidade(@RequestBody Cidade cidade){
        return cidadeService.alteraCidade(cidade);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCidade(@PathVariable("id") Long id){
        cidadeService.deletaCidade(id);
        return ResponseEntity.ok().build();
    }
    
}
