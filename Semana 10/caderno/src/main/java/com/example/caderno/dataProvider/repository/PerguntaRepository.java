package com.example.caderno.dataProvider.repository;

import com.example.caderno.dataProvider.entity.AssuntoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<AssuntoEntity, Long> {
}
