package com.udemy.cursospring.Vendas.service;

import com.udemy.cursospring.Vendas.domain.entity.Pedido;
import com.udemy.cursospring.Vendas.domain.enums.StatusPedido;
import com.udemy.cursospring.Vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
