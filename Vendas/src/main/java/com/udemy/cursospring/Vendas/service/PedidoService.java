package com.udemy.cursospring.Vendas.service;

import com.udemy.cursospring.Vendas.domain.entity.Pedido;
import com.udemy.cursospring.Vendas.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
}
