package com.clamed.repository;

import com.clamed.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//Uma interface serve para definir os contratos - Nenhuma lógica será feita aqui
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> { //Este <Long> é o tipo do PK do contato

    @Query("from Contato c where upper(c.nome) like %?1%")
    ArrayList<Contato> getContatosByName(String nome);
}
