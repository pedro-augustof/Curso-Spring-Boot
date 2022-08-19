package com.udemy.cursospring.localizacao;

import com.udemy.cursospring.localizacao.domain.entity.Cidade;
import com.udemy.cursospring.localizacao.domain.repository.CidadeRepository;
import com.udemy.cursospring.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.listarCidadesPorNomeSQL();
    }
}
