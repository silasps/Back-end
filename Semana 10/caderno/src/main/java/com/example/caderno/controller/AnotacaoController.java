package com.example.caderno.controller;

import com.example.caderno.controller.dto.AnotacaoRequest;
import com.example.caderno.controller.dto.AnotacaoResponse;
import com.example.caderno.controller.dto.TagRequest;
import com.example.caderno.controller.dto.TagResponse;
import com.example.caderno.dataProvider.entity.AnotacaoEntity;
import com.example.caderno.dataProvider.entity.TagEntity;
import com.example.caderno.dataProvider.repository.NotaRepository;
import com.example.caderno.dataProvider.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//localhost:8080/nota
@RestController
@RequestMapping("/nota")
public class AnotacaoController {

    private final NotaRepository notaRepository;//final força ter um valor e este valor não poderá ser alterado

    private final TagRepository tagRepository;

    public AnotacaoController(NotaRepository repository, TagRepository tagRepository) {
        this.notaRepository = repository;
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public ResponseEntity<List<AnotacaoResponse>> encontraNotas() {
        List<AnotacaoEntity> entityList = notaRepository.findAll();

        List<AnotacaoResponse> responseList = new ArrayList<>();
        for (AnotacaoEntity entity : entityList) {
            responseList.add(
                    new AnotacaoResponse(entity.getTitulo(), entity.getNota())
            );
        }

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity salvarNota(@RequestBody AnotacaoRequest anotacaoRequest){
        AnotacaoEntity entity = notaRepository.save(new AnotacaoEntity(anotacaoRequest.getTitulo()
                , anotacaoRequest.getNota()));

        return new ResponseEntity(
                new AnotacaoResponse(entity.getTitulo(), entity.getNota()),
                HttpStatus.CREATED
        );
    }

    // /nota/1
    @GetMapping("/{id}")
    public ResponseEntity encontraNotaPorID(@PathVariable Long id){
        AnotacaoEntity entity = notaRepository.findById(id).get();
        return new ResponseEntity<AnotacaoResponse>(
                new AnotacaoResponse(entity.getTitulo(), entity.getNota()),
                HttpStatus.OK
        );
    }

    // método de atualização de um Objeto
    // endpoint /nota/{id}
    // endpoint /nota/1 -> se refere a nota com id 1
    @PutMapping("/{id}")
    public ResponseEntity<AnotacaoResponse> atualizarNotaPorId(
            @PathVariable Long id,
            @RequestBody AnotacaoRequest request
    ) {
        AnotacaoEntity entity = notaRepository.findById(id).get(); // acho a nota de id 1
        entity.setTitulo(request.getTitulo()); // atualizo o valor do titulo da nota 1
        entity.setNota(request.getNota()); // atualizo o valor do texto da nota 1
        notaRepository.save(entity); // salvo a atualização da nota 1

        return new ResponseEntity<AnotacaoResponse>(
                // resposta rest, do tipo NotaRespose,
                // e o body da resposta é um objeto NotaRespose
//                new NotaResponse(entity.getTitulo(), entity.getNota()),

                AnotacaoResponse.builder() // permite preencher os atributos do objeto sem ter que usar um construtor
                        .titulo(entity.getTitulo())
                        .nota(entity.getNota())
                        .build(),

                HttpStatus.OK // status ok
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarNotaPorId(
            @PathVariable Long id
    ) {
        notaRepository.deleteById(id); // deleta a nota de id {id}
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/tag")
    public ResponseEntity<TagResponse> adicionarTagPorNotaId(
            @PathVariable Long id,
            @RequestBody TagRequest request
    ) {
        AnotacaoEntity anotacaoEntity = notaRepository.findById(id).get(); // acho a nota de id

        TagEntity tagEntity = tagRepository.save(
                new TagEntity(request.getTag(), anotacaoEntity) // temos que salvar tanto a tag quanto o objeto NotaEntity
        ); // Salvar uma TagEntity com os dados da requisição
        return ResponseEntity.ok(
                new TagResponse(
                        tagEntity.getTag(), tagEntity.getAnotacaoEntity().getId()
                ));
    }

    @GetMapping("/{id}/tag")
    public ResponseEntity procurarTagPorNotaId(
            @PathVariable Long id
    ) {
        AnotacaoEntity anotacaoEntity = notaRepository.findById(id).get(); // acho a nota de id

        List<TagEntity> tagEntity = tagRepository.findAll();

        return ResponseEntity.ok(
                tagEntity);
    }

    // tagEntity - id, tag, (notaEntity - id, titulo, nota, dataCriacao)
}
