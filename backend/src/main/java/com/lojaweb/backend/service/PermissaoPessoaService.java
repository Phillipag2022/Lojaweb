package com.lojaweb.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaweb.backend.model.Permissao;
import com.lojaweb.backend.model.PermissaoPessoa;
import com.lojaweb.backend.model.Pessoa;
import com.lojaweb.backend.repository.PermissaoPessoaRepository;
import com.lojaweb.backend.repository.PermissaoRepository;


@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

     @Autowired
    private PermissaoRepository permissaoRepository;



    public void vincularPermissaoPessoaCliente(Pessoa pessoa){
        List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");
        if(listaPermissao.size()>0){
            PermissaoPessoa permissaoPessoa= new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.save(permissaoPessoa);

    }
}
}
