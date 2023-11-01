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
import com.lojaweb.backend.model.Permissao;
import com.lojaweb.backend.service.PermissaoService;

@RestController
@RequestMapping("api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;
    @GetMapping("/")
    public List<Permissao> listaTodas(){
        return permissaoService.listarTodas();
    }
    @PostMapping("/")
    public ResponseEntity<Permissao> salvaPermissao(@RequestBody Permissao permissao){
        return permissaoService.salvaPermissao(permissao);
    }
    @PutMapping("/")
    public ResponseEntity<Permissao> alteraPermissao(@RequestBody Permissao permissao){
        return permissaoService.alteraPermissao(permissao);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaPermissao(@PathVariable("id")Long id){
        permissaoService.deletaPermissao(id);
        return ResponseEntity.ok().build();
    }
}
