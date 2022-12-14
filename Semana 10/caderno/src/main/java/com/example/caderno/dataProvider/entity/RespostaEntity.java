package com.example.caderno.dataProvider.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resposta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String texto;

    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private PerguntaEntity perguntaEntity;

    public RespostaEntity(String texto, Long id_pergunta, PerguntaEntity perguntaEntity){
        this.texto = texto;
        this.perguntaEntity = perguntaEntity;
    }

}
