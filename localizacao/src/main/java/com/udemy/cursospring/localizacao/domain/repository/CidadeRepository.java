package com.udemy.cursospring.localizacao.domain.repository;

import com.udemy.cursospring.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNome(String nome);

    // Ao usar % posso buscar por cidades que tenham qualquer nome após ou antes do %
    List<Cidade> findByNomeLike(String nome);

    // mesma coisa que o find by nome like porem pode ser digitado tanto maiúculo quanto minúsuclo
    @Query(" select c from Cidade c where lower(c.nome) like lower(?1) ")
    List<Cidade> findByNomeLikeNoSensitive(String nome);

    List<Cidade> findByNomeStartingWith(String nome);

    List<Cidade> findByNomeEndingWith(String nome);

    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);
}
