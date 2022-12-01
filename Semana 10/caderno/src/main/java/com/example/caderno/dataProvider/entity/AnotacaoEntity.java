package com.example.caderno.dataProvider.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "nota")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnotacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String nota;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public AnotacaoEntity(String titulo, String nota){
        this.titulo = titulo;
        this.nota = nota;
        this.dataCriacao = LocalDateTime.now();
    }
}
