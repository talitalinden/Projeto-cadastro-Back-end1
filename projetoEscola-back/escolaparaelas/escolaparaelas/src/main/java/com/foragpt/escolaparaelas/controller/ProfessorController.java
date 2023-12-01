package com.foragpt.escolaparaelas.controller;

import com.foragpt.escolaparaelas.model.Funcionario;
import com.foragpt.escolaparaelas.model.Professor;
import com.foragpt.escolaparaelas.repositorio.ProfessorRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/professores")
public class ProfessorController {

    private final ProfessorRepositorio professorRepositorio;

    public ProfessorController(ProfessorRepositorio professorRepositorio) {
        this.professorRepositorio = professorRepositorio;
    }

    @GetMapping
    public List<Professor> findAll() {
        return professorRepositorio.findAll();
    }

    @PostMapping
    public Long cadastrarProfessor(@RequestBody ProfessorRequestBody body) {

        Professor professor = new Professor();

        professor.setNome(body.getNome());
        professor.setDataNascimento(body.getDataNascimento());
        professor.setTelefone(body.getTelefone());
        professor.setCep(body.getCep());
        professor.setLogradouro(body.getLogradouro());
        professor.setNumero(body.getNumero());
        professor.setCidade(body.getCidade());
        professor.setUf(body.getUf());
        professor.setEspecialidade(body.getEspecialidade());
        professor.setDataDeContratacao(body.getDataDeContratacao());

        return professorRepositorio.save(professor).getId();
    }

    @PutMapping(path = "/{id}")
    public void atualizarProfessor(@PathVariable("id") Long id, @RequestBody ProfessorRequestBody body) {

        Professor professor = professorRepositorio.getReferenceById(id);

        professor.setNome(body.getNome());
        professor.setDataNascimento(body.getDataNascimento());
        professor.setTelefone(body.getTelefone());
        professor.setCep(body.getCep());
        professor.setLogradouro(body.getLogradouro());
        professor.setNumero(body.getNumero());
        professor.setCidade(body.getCidade());
        professor.setUf(body.getUf());
        professor.setEspecialidade(body.getEspecialidade());
        professor.setDataDeContratacao(body.getDataDeContratacao());

        professorRepositorio.save(professor);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarProfessor(@PathVariable Long id){
        professorRepositorio.deleteById(id);
    }
}