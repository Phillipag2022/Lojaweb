package com.lojaweb.backend.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.lojaweb.backend.model.Pessoa;
import com.lojaweb.backend.repository.PessoaRepository;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;
   
    @Autowired
    private EmailService emailService;
   
    public ResponseEntity<String> solicitarCodigo(@RequestBody String email){
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperaçaoSenha(getCodigoRecuperaçaoSemha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        pessoaRepository.save(pessoa);
        emailService.envioEmail(pessoa.getEmail(),"Codigo de recuperação de senha","Ola!! O seu codigo para recuperação de senha é o seguinte "+pessoa.getCodigoRecuperaçaoSenha());
        return new ResponseEntity<String>("Codigo Enviado!!", HttpStatus.CREATED);

    }

     public ResponseEntity<String> alterarSenha(@RequestBody Pessoa pessoa){
        Pessoa pessoa2 = pessoaRepository.findByEmailAndCodigoRecuperaçaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperaçaoSenha());

        if(pessoa2 != null){
        Date diferença = new Date(new Date().getTime() - pessoa2.getDataEnvioCodigo().getTime());

            if(diferença.getTime()/1000 <900){
                pessoa2.setSenha(pessoa.getSenha());
                pessoa2.setCodigoRecuperaçaoSenha(null);
                pessoaRepository.save(pessoa2);
            }else{
                return new ResponseEntity<String>("Tempo expirado!! Solicite um novo codigo", HttpStatus.OK);
        }
        }else{
            return new ResponseEntity<String>("Email ou codigo nso encontrado", HttpStatus.OK);
        }
    return new ResponseEntity<String>("Senha alterada com sucesso!!!", HttpStatus.CREATED);
    }




    public String getCodigoRecuperaçaoSemha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+id;
    }
    
}
