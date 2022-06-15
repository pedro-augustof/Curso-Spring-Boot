package com.udemy.cursospring.Vendas.domain.repository;

import com.udemy.cursospring.Vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
