package com.lojaweb.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.lojaweb.backend.model.Permissao;
import com.lojaweb.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> listarTodas(){
        return permissaoRepository.findAll();
    }

    public ResponseEntity<Permissao> salvaPermissao(@RequestBody Permissao permissao){
        permissao.setDataCriacao(new Date());
        Permissao novaPermissao = permissaoRepository.save(permissao);
        return new ResponseEntity<Permissao>(novaPermissao, HttpStatus.CREATED);
    }

    public ResponseEntity<Permissao> alteraPermissao(@RequestBody Permissao permissao){
        permissao.setDataAtualizacao(new Date());
        return new ResponseEntity<Permissao>(permissaoRepository.save(permissao), HttpStatus.OK);
    }

    public void deletaPermissao(Long id){
        Permissao idPermissao = this.permissaoRepository.findById(id).get();
        permissaoRepository.delete(idPermissao);
    }
}
