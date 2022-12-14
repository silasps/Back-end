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
public class PerguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_assunto")
    private AssuntoEntity assuntoEntity;

    public PerguntaEntity(String titulo, String texto, AssuntoEntity assuntoEntity){
        this.titulo = titulo;
        this.texto = texto;
        this.assuntoEntity = assuntoEntity;
    }

}
