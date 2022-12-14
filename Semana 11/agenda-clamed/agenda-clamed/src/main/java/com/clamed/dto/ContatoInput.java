package com.clamed.dto;

import com.clamed.model.Grupo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoInput {

    private Long id;
    private String nome;
    private String telefoneFixo;
    private String telefoneCelular;
    private String telefoneTrabalho;
    private String email;

    private Grupo grupo;
}
