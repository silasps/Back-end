package com.example.caderno.dataProvider.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perguntas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PerguntasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String texto;

    @Column
    private Long id_assunto;

    @ManyToOne
    @JoinColumn
    public AssuntoEntity assuntoEntity;

    public PerguntasEntity(String titulo, String texto, Long id_assunto, AssuntoEntity assuntoEntity){
        this.titulo = titulo;
        this.texto = texto;
        this.id_assunto = id_assunto;
        this.assuntoEntity = assuntoEntity;
    }

}
