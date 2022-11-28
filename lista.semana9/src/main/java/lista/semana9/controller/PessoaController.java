package lista.semana9.controller;

import lista.semana9.entity.PessoaEntity;
import lista.semana9.service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    public PessoaService service;

    public PessoaController(PessoaService service){
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody PessoaEntity pessoa){
        service.save(pessoa);
    }

    @GetMapping
    public List<PessoaEntity> buscarTudo(){
        return service.buscarTodasAsPessoas();
    }

}
