package com.foragpt.escolaparaelas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Pessoa {

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "data_de_contratacao")
    private LocalDate dataDeContratacao;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(LocalDate dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }
}
