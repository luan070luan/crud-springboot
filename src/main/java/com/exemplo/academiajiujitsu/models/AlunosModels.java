package com.exemplo.academiajiujitsu.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "alunos_jiujitsu")
public class AlunosModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private BigDecimal idade;
    private String faixa;


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getIdade() {
        return idade;
    }

    public void setIdade(BigDecimal idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }





}
