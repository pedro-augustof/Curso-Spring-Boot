package com.udemy.cursospring.localizacao.domain.repository;

import com.udemy.cursospring.localizacao.domain.entity.Cidade;
import com.udemy.cursospring.localizacao.domain.repository.projections.CidadeProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    @Query(nativeQuery = true, value = " select c.nome from tb_cidade as c where c.nome =:nome ")
    List<String> findByNomeSqlNativo(@Param("nome") String nome);

    @Query(nativeQuery = true, value = " select c.nome, c.id_cidade as id from tb_cidade as c where c.nome =:nome ")
    List<CidadeProjection> findByNomeSqlNativoProjection(@Param("nome") String nome);

    List<Cidade> findByNome(String nome);

    // Ao usar % posso buscar por cidades que tenham qualquer nome após ou antes do %
    List<Cidade> findByNomeLike(String nome);

    // Ordenado
    // mesma coisa que o find by nome like porem pode ser digitado tanto maiúculo quanto minúsuclo
    @Query(" select c from Cidade c where lower(c.nome) like lower(?1) ")
    List<Cidade> findByNomeLikeNoSensitive(String nome, Sort sort);

    // Paginado
    @Query(" select c from Cidade c where lower(c.nome) like lower(?1) ")
    List<Cidade> findByNomeLikeNoSensitive(String nome, Pageable pageable);

    List<Cidade> findByNomeStartingWith(String nome);

    List<Cidade> findByNomeEndingWith(String nome);

    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);
    
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);
}
