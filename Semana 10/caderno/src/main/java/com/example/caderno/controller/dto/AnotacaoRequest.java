package com.example.caderno.controller.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnotacaoRequest {

    @Column
    private String titulo;

    @Column
    private String nota;

}
