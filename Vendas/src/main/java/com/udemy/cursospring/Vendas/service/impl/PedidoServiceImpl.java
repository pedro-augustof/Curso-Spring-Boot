package com.udemy.cursospring.Vendas.service.impl;

import com.udemy.cursospring.Vendas.domain.entity.Cliente;
import com.udemy.cursospring.Vendas.domain.entity.ItemPedido;
import com.udemy.cursospring.Vendas.domain.entity.Pedido;
import com.udemy.cursospring.Vendas.domain.entity.Produto;
import com.udemy.cursospring.Vendas.domain.repository.Clientes;
import com.udemy.cursospring.Vendas.domain.repository.ItensPedido;
import com.udemy.cursospring.Vendas.domain.repository.Pedidos;
import com.udemy.cursospring.Vendas.domain.repository.Produtos;
import com.udemy.cursospring.Vendas.exception.RegraNegocioException;
import com.udemy.cursospring.Vendas.rest.dto.ItemPedidoDTO;
import com.udemy.cursospring.Vendas.rest.dto.PedidoDTO;
import com.udemy.cursospring.Vendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;

    private final Clientes clientesRepository;

    private final Produtos produtosRepository;

    private final ItensPedido itensPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedidos = converterItens(pedido, dto.getItems());
        repository.save(pedido);
        itensPedidoRepository.saveAll(itensPedidos);
        pedido.setItens(itensPedidos);

        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
        }

        return itens.stream().map(dto -> {
            Integer idProduto = dto.getProduto();
            Produto produto = produtosRepository.findById(idProduto).orElseThrow(() -> new RegraNegocioException(("Código de produto inválido: " + idProduto)));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);

            return itemPedido;
        }).collect(Collectors.toList());
    }
}
