package com.lojaweb.backend.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lojaweb.backend.model.Marca;
import com.lojaweb.backend.service.MarcaService;

@RestController
@RequestMapping("api/marca")
public class MarcaController {
    
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> listaTodos(){
        return marcaService.listaTodos();
    }
    
    @PostMapping("/")
    public ResponseEntity<Marca> salvaMarca(@RequestBody Marca marca){
        return marcaService.salvaMarca(marca);
    }

    @PutMapping("/")
    public ResponseEntity<Marca> alteraMarca(@RequestBody Marca marca){
        return marcaService.alteraMarca(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaMarca(@PathVariable("id") Long id){
        marcaService.deletaMarca(id);
        return ResponseEntity.ok().build();
    }
}
