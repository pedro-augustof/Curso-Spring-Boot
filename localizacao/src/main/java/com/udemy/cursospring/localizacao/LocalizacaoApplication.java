package com.udemy.cursospring.localizacao;

import com.udemy.cursospring.localizacao.domain.entity.Cidade;
import com.udemy.cursospring.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        listarCidadesPorNome();
    }

    @Transactional
    void salvarCidade(){
        var cidade = new Cidade(1L, "São Paulo", 12396372L);
        cidadeRepository.save(cidade);
    }

    void listarCidadesPorHabitantes(){
        cidadeRepository.findByHabitantes(78787900L).forEach(System.out::println);
    }

    void listarCidadesPorNome(){
        cidadeRepository.findByNome("Porto Velho").forEach(System.out::println);
        cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
        cidadeRepository.findByNomeEndingWith("a").forEach(System.out::println);
        cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
        cidadeRepository.findByNomeLike("%za").forEach(System.out::println);
        cidadeRepository.findByNomeLikeNoSensitive("PORTO%").forEach(System.out::println);
    }

    void listarCidades(){
        cidadeRepository.findAll().forEach(System.out::println);
    }
}
