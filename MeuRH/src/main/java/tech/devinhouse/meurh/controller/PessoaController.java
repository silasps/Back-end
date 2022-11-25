package tech.devinhouse.meurh.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.devinhouse.meurh.model.PessoaModel;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.meurh.service.PessoaService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

    public PessoaController(PessoaService service){
        this.service = service;
    }

    @GetMapping()
    public List<PessoaModel> getPessoas(){
        return service.getPessoas();
    }

    @PostMapping()
    public ResponseEntity<PessoaModel> postPessoas(@RequestBody PessoaModel pessoa){
        return new ResponseEntity<>(service.savePessoas(pessoa), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public PessoaModel getPessoasById(@PathVariable("id")Long id){
        return service.getPessoaById(id);
    }

    @GetMapping("/email/{name}")
    public List<String> getEmailsByName(@PathVariable("name")String name){ //retornar emails das pessoas
        return service.getEmailsByName(name);
    }

    @DeleteMapping("/id/{id}")
    public void deletePessoaById(@PathVariable("id")Long id){
        service.delete(id);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<PessoaModel> updatePessoa(@PathVariable("id")Long id, @RequestBody PessoaModel pessoa){
        return new ResponseEntity<>(service.updatePessoa(pessoa, id), HttpStatus.OK);
    }
}
