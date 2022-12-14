package com.clamed.controllers;

import com.clamed.dto.ContatoInput;
import com.clamed.dto.ContatoOutput;
import com.clamed.model.Contato;
import com.clamed.service.CadastroContatoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {

    @Autowired //cria o constructor automaticamente
    private CadastroContatoService cadastroContatoService;

    @PostMapping
    public ResponseEntity<ContatoOutput> cadastrar(@RequestBody ContatoInput contatoInput){

        //Crio um objeto do tipo Entity
        Contato contato = new Contato();

        //Faz a conversão do DTO de entrada para o objeto Entity
        BeanUtils.copyProperties(contatoInput, contato);

        Contato c = cadastroContatoService.salvar(contato);

        // Crio um objeto DTO de saída
        ContatoOutput co = new ContatoOutput(); //cria um output

        // Faz a conversão do objeto do tipo Entity para DTO de saída
        BeanUtils.copyProperties(c, co);

        // Montamos a resposta da requisição
        return new ResponseEntity<ContatoOutput>(co, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ContatoOutput> atualizar(@RequestBody ContatoInput contatoInput){

        //Crio um objeto do tipo Entity
        Contato contato = new Contato();

        //Faz a conversão do DTO de entrada para o objeto Entity
        BeanUtils.copyProperties(contatoInput, contato);

        Contato c = cadastroContatoService.salvar(contato);

        // Crio um objeto DTO de saída
        ContatoOutput co = new ContatoOutput(); //cria um output

        // Faz a conversão do objeto do tipo Entity para DTO de saída
        BeanUtils.copyProperties(c, co);

        // Montamos a resposta da requisição
        return new ResponseEntity<ContatoOutput>(co, HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idContato){

        cadastroContatoService.deleteById(idContato);

        return new ResponseEntity<String>("Contato ID: "+idContato+ "deletado com sucesso", HttpStatus.OK);
    }


    // TODO fazer a conversão da resposta para DTO de saída
    @GetMapping
    public ResponseEntity<List<Contato>> getContatoByName(@RequestParam(name = "nome") String nome){

        List<Contato> contatos = cadastroContatoService.getContatoByName(nome);

        return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
    }

}
