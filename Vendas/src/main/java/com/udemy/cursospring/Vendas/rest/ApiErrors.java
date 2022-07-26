package com.udemy.cursospring.Vendas.rest;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> error;

    public ApiErrors(List<String> error) {
        this.error = error;
    }

    public ApiErrors(String mensagemErro){
        this.error = Arrays.asList(mensagemErro);
    }
}
