package com.lojaweb.backend.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.lojaweb.backend.DTO.PessoaClienteDTO;
import com.lojaweb.backend.model.Pessoa;
import com.lojaweb.backend.repository.PessoaClienteRepository;


@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaClienteRepository;
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;
    @Autowired
    private EmailService emailService;
   
    public List<Pessoa> listarTodos(){
        return pessoaClienteRepository.findAll();
    }

    public ResponseEntity<Pessoa> salvaPessoa(@RequestBody PessoaClienteDTO pessoaClienteDTO){
        Pessoa pessoa = new PessoaClienteDTO().convertPessoa(pessoaClienteDTO);
        pessoa.setDataCriaçao(new Date());
        Pessoa novaPessoa = pessoaClienteRepository.save(pessoa);
        permissaoPessoaService.vincularPermissaoPessoaCliente(novaPessoa);
        Map<String, Object> propMap = new HashMap<>();
        propMap.put("nome",novaPessoa.getNome());
        propMap.put("mensagem", "Cadastro na lojaweb realizadom com sucesso!! Utilize o esqueceu senha para gerar senha de acesso.");
        emailService.enviarEmailTemplate(novaPessoa.getEmail(), "cadastro ma lojaweb", propMap);
        //emailService.envioEmail(novaPessoa.getEmail(),"cadastro ma lojaweb","Cadastro na lojaweb realizadom com sucesso!! Utilize o esqueceu senha para gerar senha de acesso.");
        
        return new ResponseEntity<Pessoa>(novaPessoa, HttpStatus.CREATED);
       
    }

    public ResponseEntity<Pessoa> alteraPessoa(@RequestBody Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        return new ResponseEntity<Pessoa>(pessoaClienteRepository.save(pessoa), HttpStatus.OK);
    }
    
    public void deletaPessoa(Long id){
        Pessoa idPesssoa = this.pessoaClienteRepository.findById(id).get();
        pessoaClienteRepository.delete(idPesssoa);
    }
}
