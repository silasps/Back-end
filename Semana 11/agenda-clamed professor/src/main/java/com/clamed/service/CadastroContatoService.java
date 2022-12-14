package com.clamed.service;


import com.clamed.model.Contato;
import com.clamed.repository.ContatoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CadastroContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    //private static final Logger logger = LoggerFactory.getLogger(CadastroContatoService.class);


    public Contato salvar(Contato contato){

        log.trace("Uma mensagem de TRACE");
        log.debug("Uma mensagem de DEBUG");
        log.info("Uma mensagem de INFO");
        log.warn("Uma mensagem de AVISO");
        log.error("Uma mesagem de ERRO");

        return contatoRepository.save(contato);
    }

    public void deleteById(Long idContato){
        contatoRepository.deleteById(idContato);
    }

    public List<Contato> getContatosByName(String nome){
        //List<Contato> contatos =
        return contatoRepository.getContatosByName(nome);
    }


}
