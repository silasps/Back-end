package com.example.caderno.dataProvider.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assunto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssuntoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    public AssuntoEntity(String nome){
        this.nome = nome;
    }

}
