package com.example.caderno.controller;

import com.example.caderno.controller.dto.NotaRequest;
import com.example.caderno.controller.dto.NotaResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @GetMapping
    public NotaResponse encontraNotas(){
        return new NotaResponse("Titulo Nota", "Nota Criada");
    }

    @PostMapping
    public NotaResponse salvaNota(@RequestBody NotaRequest notaRequest){
        //lógica
        return new NotaResponse(notaRequest.getTitulo(), notaRequest.getNota());
    }
}
