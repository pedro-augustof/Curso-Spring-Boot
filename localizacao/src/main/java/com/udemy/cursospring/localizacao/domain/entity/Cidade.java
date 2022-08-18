package com.udemy.cursospring.localizacao.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_cidade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    private Long id;

    @Column(length = 50)
    private String nome;

    @Column(name = "qtd_habitantes")
    private Long habitantes;
}
