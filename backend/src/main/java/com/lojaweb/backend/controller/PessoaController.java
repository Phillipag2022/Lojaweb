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
import com.lojaweb.backend.model.Pessoa;
import com.lojaweb.backend.service.PessoaService;


@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    private PessoaService pessoaService;
    @GetMapping("/")
    public List<Pessoa> BuscaTodos(){
        return pessoaService.listarTodos();
    }
    @PostMapping("/")
    public ResponseEntity<Pessoa> salvaPessoa(@RequestBody Pessoa pessoa){
       return pessoaService.salvaPessoa(pessoa);

    }
    @PutMapping("/")
    public ResponseEntity<Pessoa> alteraPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.alteraPessoa(pessoa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable("id") Long id){
        pessoaService.deletaPessoa(id);
        return ResponseEntity.ok().build();
    }
    
}
