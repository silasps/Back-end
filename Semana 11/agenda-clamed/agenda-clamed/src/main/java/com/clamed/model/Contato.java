package com.clamed.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter

@Entity
@Table(name="contato") //define o nome da tabela que vai ser criada no banco
public class Contato implements Serializable { //o objeto será serializado antes de ser persistido

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

    @OneToOne
    @JoinColumn(name = "idGrupo", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_grupo"))
    private Grupo grupo;
}
