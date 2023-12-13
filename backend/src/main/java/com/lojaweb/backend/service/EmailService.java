package com.lojaweb.backend.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.*;




@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender; 
    @Autowired
    private Configuration fmConfiguration;

    @Value("{$spring.mail.username}")
    private String remetente;

    public String envioEmail(String destinatario,String titulo,String menssagem){
        
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom(remetente);
                simpleMailMessage.setTo(destinatario);
                simpleMailMessage.setSubject(titulo);
                simpleMailMessage.setText(menssagem);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado com sucesso";
        }catch (Exception ex ){
           return"Falha ao enviar email!";
        }
    }

    public void enviarEmailTemplate(String destinatario,String titulo, Map<String, Object> propriedades){
       MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setSubject(titulo);
            mimeMessageHelper.setFrom(remetente);
            mimeMessageHelper.setTo(destinatario);

            mimeMessageHelper.setText(getConteudoTemplate(propriedades),true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }

    public String getConteudoTemplate(Map<String, Object> modelMap){
        StringBuffer content = new StringBuffer();
        try{
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate("email-recuperacao-codigo.flth"),modelMap));
        }catch(Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }
}
