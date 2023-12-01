package com.foragpt.escolaparaelas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id")
public class Aluno extends Pessoa {

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "data_de_ingresso")
    private LocalDate dataDeIngresso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_turma")
    private Turma turma;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataDeIngresso() {
        return dataDeIngresso;
    }

    public void setDataDeIngresso(LocalDate dataDeIngresso) {
        this.dataDeIngresso = dataDeIngresso;
    }
}
