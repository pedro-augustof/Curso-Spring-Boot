package com.udemy.cursospring.Vendas.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException(){
        super("Pedido não encontrado.");
    }
}
