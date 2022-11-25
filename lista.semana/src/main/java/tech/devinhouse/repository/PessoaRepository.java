package tech.devinhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.entity.PessoaEntity;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

    List<PessoaEntity> findByStatus(Boolean Status);

    Long countByStatus(Boolean status);

    @Query(value = "select * from pessoas\n" +
                "where name like %:filter%\n" +
                "or email like %:filter%", nativeQuery = true)
    List<PessoaEntity>buscarPessoaPorNomeOuEmail(String filter);

}
