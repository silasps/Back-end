package tech.devinhouse.controller;

import org.springframework.web.bind.annotation.*;
import tech.devinhouse.entity.PessoaEntity;
import tech.devinhouse.service.PessoaService;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

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

    @GetMapping("/{id}")
    public PessoaEntity buscaPorId(@PathVariable("id") Long id){
        return service.buscaPessoaPorId(id);
    }

    @GetMapping("/status-true")
    public List<PessoaEntity> buscarStatusTrue(){
        return service.buscarPessoaPorStatusTrue();
    }

    @GetMapping("/status-true-number")
    public Long findNumber(){
        return service.buscarQtdStatusTrue();
    }

    @PutMapping
    public void updatePessoa(@RequestBody PessoaEntity pessoa){
        service.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletePessoaPorId(@PathVariable("id") Long id){
        service.deletePorId(id);
    }

    @GetMapping("/filter")
    public List<PessoaEntity> buscaPessoaPeloFiltro(@RequestParam("q") String filter){
        return service.filtraPessoas(filter);
    }
}
