package tech.devinhouse.meurh.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tech.devinhouse.meurh.model.PessoaModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
@Component
public class PessoaRepository {

    private static List<PessoaModel> pessoas = new ArrayList<>();

    public PessoaModel save(PessoaModel pessoa){
        pessoa.setId((long) pessoas.size());
        pessoas.add(pessoa);
        return pessoa;
    }

    public void delete(PessoaModel id){
        pessoas.remove(id);
    }

    public List<PessoaModel> findAll(){
//        return Collections.unmodifiableList(pessoas); //Bloqueia as alterações na lista
        return new ArrayList<>(pessoas); //Criar uma cópia do Array
    }

    public PessoaModel findById(Long id){
        return pessoas.stream().filter(pessoas -> pessoas.getId() == id).findFirst().orElse(null);
    }

    public List<String> findEmailsByName(String name){ //retornar emails das pessoas
        return pessoas.stream().filter(pessoa -> pessoa.getName().contains(name)).map(pessoa -> pessoa.getEmail()).collect(Collectors.toList());
    }
}
