package com.clamed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter

@Entity
@Table(name="contato")
public class Contato implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String nome;


    @Column(length = 120)
    private String email;

    @Column(length = 45)
    private String telefoneFixo;

    @Column(length = 45)
    private String telefoneCelular;

    @Column(length = 45)
    private String telefoneTrabalho;

    private Long idGrupo;


}
