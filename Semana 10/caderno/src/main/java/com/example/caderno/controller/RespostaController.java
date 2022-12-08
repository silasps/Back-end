package com.example.caderno.controller;

import com.example.caderno.dataProvider.repository.AssuntoRepository;
import com.example.caderno.dataProvider.repository.PerguntasRepository;
import com.example.caderno.dataProvider.repository.RespostaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assunto")
public class PerguntasController {

    private final AssuntoRepository assuntoRepository;

    private final PerguntasRepository perguntasRepository;

    private RespostaRepository respostaRepository;

    public PerguntasController(AssuntoRepository assuntoRepository, PerguntasRepository perguntasRepository, RespostaRepository respostaRepository){
        this.assuntoRepository = assuntoRepository;
        this.perguntasRepository = perguntasRepository;
        this.respostaRepository = respostaRepository;
    }

}
