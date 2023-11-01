package com.lojaweb.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lojaweb.backend.model.Marca;
import com.lojaweb.backend.repository.MarcaRepository;

@Service
public class MarcaService {
    
     @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listaTodos(){
        return marcaRepository.findAll();
    }

    public ResponseEntity<Marca> salvaMarca(Marca marca){
        Marca novaMarca = marcaRepository.save(marca);
        return new ResponseEntity<Marca>(novaMarca, HttpStatus.CREATED);
    }

    public ResponseEntity<Marca> alteraMarca(Marca marca){
        return new ResponseEntity<>(marcaRepository.save(marca), HttpStatus.OK);
    }

    public void deletaMarca(Long id){
        Marca idMarca = this.marcaRepository.findById(id).get();
        marcaRepository.delete(idMarca);
    }
}
