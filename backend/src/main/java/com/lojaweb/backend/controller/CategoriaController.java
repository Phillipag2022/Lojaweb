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

import com.lojaweb.backend.model.Categoria;
import com.lojaweb.backend.service.CategoriaService;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> listaTodas(){
        return categoriaService.listaTodos();
    }
    @PostMapping("/")
    public ResponseEntity<Categoria> salvaCategoria(@RequestBody Categoria categoria){
        return categoriaService.salvaCategoria(categoria);
    }
    @PutMapping("/")
    public ResponseEntity<Categoria> alteraCategoria(@RequestBody Categoria categoria){
        return categoriaService.alteraCategoria(categoria);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCategoria(@PathVariable("id") Long id){
        categoriaService.deletaCategoria(id);   
        return ResponseEntity.ok().build();
     }

}
