package com.example.caderno.dataProvider.repository;

import com.example.caderno.dataProvider.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Long> {



}
