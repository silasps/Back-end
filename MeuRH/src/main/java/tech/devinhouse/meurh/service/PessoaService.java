package tech.devinhouse.meurh.service;

import lombok.AllArgsConstructor;
import tech.devinhouse.meurh.model.PessoaModel;
import org.springframework.stereotype.Service;
import tech.devinhouse.meurh.repository.PessoaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public List<PessoaModel> getPessoas(){
        return pessoaRepository.findAll();
    }

    public PessoaModel savePessoas(PessoaModel pessoa){
        return pessoaRepository.save(pessoa);
    }

    public PessoaModel updatePessoa(PessoaModel pessoa, Long id){
        var pessoaParaUpdate = getPessoaById(id);
        pessoaParaUpdate.setName(pessoa.getName());
        pessoaParaUpdate.setEmail(pessoa.getEmail());
        return getPessoaById(id);
    }

    public void delete(Long id){
        var pessoaParaDeletar = getPessoaById(id);
        pessoaRepository.delete(pessoaParaDeletar);
    }

    public PessoaModel getPessoaById(Long id){
        return pessoaRepository.findById(id);
    }

    public List<String> getEmailsByName(String name){ //retornar emails das pessoas
        return pessoaRepository.findEmailsByName(name);
    }

}
