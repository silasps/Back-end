package com.clamed.controllers;

import com.clamed.model.Contato;
import com.clamed.service.CadastroContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {

    @Autowired
    private CadastroContatoService cadastroContatoService;

    @PostMapping
    public ResponseEntity<Contato> cadastrar(@RequestBody Contato contato){
        Contato c = cadastroContatoService.salvar(contato);
        return new ResponseEntity<Contato>(c, HttpStatus.CREATED);
    }




}
