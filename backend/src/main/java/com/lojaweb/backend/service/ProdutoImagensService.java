package com.lojaweb.backend.service;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.lojaweb.backend.model.Produto;
import com.lojaweb.backend.model.ProdutoImagens;
import com.lojaweb.backend.repository.ProdutoImagensRepository;
import com.lojaweb.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagensService {

     @Autowired
    private ProdutoImagensRepository produtoImagensRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> listaTodos(){
        return produtoImagensRepository.findAll();
    }

    public ResponseEntity<ProdutoImagens> salvaProdutoImagens(Long id, MultipartFile file){
        
        Produto novoProduto = produtoRepository.findById(id).get();
        ProdutoImagens produtoImagens = new ProdutoImagens();
            try {
                if(!file.isEmpty()){
                    byte [] bytes= file.getBytes();
                    String nomeImagem  = String.valueOf(novoProduto.getId())+ file.getOriginalFilename();
                    Path caminho = Paths  
                        .get("c:/imagens/" +nomeImagem);
                    Files.write(caminho, bytes);
                    produtoImagens.setNome(nomeImagem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        produtoImagens.setProduto(novoProduto);
        produtoImagens.setDataCricao(new Date());
        ProdutoImagens novaProdutoImagens = produtoImagensRepository.save(produtoImagens);
        return new ResponseEntity<ProdutoImagens>(novaProdutoImagens, HttpStatus.CREATED);
    }

    public ResponseEntity<ProdutoImagens> alteraProdutoImagens(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        return new ResponseEntity<>(produtoImagensRepository.save(produtoImagens), HttpStatus.OK);
    }

    public void deletaProdutoImagens(Long id){
         ProdutoImagens idProdutoImagens = this.produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(idProdutoImagens);
    }

    
}
