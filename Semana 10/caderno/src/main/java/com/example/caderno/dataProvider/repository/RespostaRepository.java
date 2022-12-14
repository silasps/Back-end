package com.example.caderno.dataProvider.repository;

import com.example.caderno.dataProvider.entity.AssuntoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository  extends JpaRepository<AssuntoEntity, Long> {
}
