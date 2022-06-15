package com.udemy.cursospring.Vendas.domain.repository;

import com.udemy.cursospring.Vendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
