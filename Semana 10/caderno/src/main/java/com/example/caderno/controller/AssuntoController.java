package com.example.caderno.controller;

import com.example.caderno.controller.dto.AssuntoRequest;
import com.example.caderno.controller.dto.AssuntoResponse;
import com.example.caderno.dataProvider.entity.AssuntoEntity;
import com.example.caderno.dataProvider.repository.AssuntoRepository;
import com.example.caderno.dataProvider.repository.PerguntaRepository;
import com.example.caderno.dataProvider.repository.RespostaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assunto")
public class AssuntoController {

    private final AssuntoRepository assuntoRepository;

    private final PerguntaRepository perguntaRepository;

    private RespostaRepository respostaRepository;

    public AssuntoController(AssuntoRepository repository, PerguntaRepository perguntaRepository){
        this.assuntoRepository = repository;
        this.perguntaRepository = perguntaRepository;
    }



    @GetMapping
    public ResponseEntity retornaAssuntos(){
        List<AssuntoEntity> assuntoEntityList = assuntoRepository.findAll();
        List<AssuntoResponse> assuntoResponseList = new ArrayList<>();
        for (AssuntoEntity entity : assuntoEntityList){
            assuntoResponseList.add(
                    new AssuntoResponse(entity.getNome()));
        }
        return ResponseEntity.ok(assuntoResponseList);
    }

    @PostMapping
    public ResponseEntity<AssuntoResponse> salvarAssunto(@RequestBody AssuntoRequest request) {
        AssuntoEntity entity = assuntoRepository.save(new AssuntoEntity(request.getNome()));

        return new ResponseEntity<AssuntoResponse>(
                new AssuntoResponse(entity.getNome()),
                HttpStatus.CREATED
        );
    }
}
