package lista.semana9.service;

import lista.semana9.entity.PessoaEntity;
import lista.semana9.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    public PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }

    public void save(PessoaEntity pessoa){
        repository.save(pessoa);
    }

    public List<PessoaEntity> buscarTodasAsPessoas(){
        return repository.findAll();
    }

}
