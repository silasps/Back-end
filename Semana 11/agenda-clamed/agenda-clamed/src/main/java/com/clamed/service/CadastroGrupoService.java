package com.clamed.service;

import com.clamed.model.Grupo;
import com.clamed.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo salvar(Grupo grupo){
        return grupoRepository.save(grupo);
    }

    public Grupo getGrupoById(Long idGrupo){
        return grupoRepository.findById(idGrupo).get();
    }

    public void deleteById(Long idGrupo){
        grupoRepository.deleteById(idGrupo);
    }

    public List<Grupo> getGrupos(){
        return grupoRepository.findAll();
    }
}
