package com.foragpt.escolaparaelas.controller;

import com.foragpt.escolaparaelas.model.Aluno;
import com.foragpt.escolaparaelas.model.Turma;
import com.foragpt.escolaparaelas.repositorio.AlunoRepositorio;
import com.foragpt.escolaparaelas.repositorio.TurmaRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    private final TurmaRepositorio turmaRepositorio;
    private final AlunoRepositorio alunoRepositorio;

    public AlunoController(TurmaRepositorio turmaRepositorio, AlunoRepositorio alunoRepositorio) {
        this.turmaRepositorio = turmaRepositorio;
        this.alunoRepositorio = alunoRepositorio;
    }

    @GetMapping
    public List<Aluno> findAll() {
        return alunoRepositorio.findAll();
    }

    @PostMapping
    public Long cadastrarAluno(@RequestBody AlunoRequestBody body) {
        Turma turma = turmaRepositorio.getReferenceById(body.getIdTurma());

        Aluno aluno = new Aluno();

        aluno.setNome(body.getNome());
        aluno.setDataNascimento(body.getDataNascimento());
        aluno.setTelefone(body.getTelefone());
        aluno.setMatricula(body.getMatricula());
        aluno.setTurma(turma);
        aluno.setDataDeIngresso(body.getDataDeIngresso());
        aluno.setCep(body.getCep());
        aluno.setLogradouro(body.getLogradouro());
        aluno.setNumero(body.getNumero());
        aluno.setCidade(body.getCidade());
        aluno.setUf(body.getUf());

        return alunoRepositorio.save(aluno).getId();
    }

    @PutMapping(path = "/{id}")
    public void atualizarAluno(@PathVariable ("id")Long id, @RequestBody AlunoRequestBody body){
        Aluno aluno = alunoRepositorio.getReferenceById(id);
        Turma turma = turmaRepositorio.getReferenceById(body.getIdTurma());

        aluno.setNome(body.getNome());
        aluno.setDataNascimento(body.getDataNascimento());
        aluno.setTelefone(body.getTelefone());
        aluno.setMatricula(body.getMatricula());
        aluno.setTurma(turma);
        aluno.setDataDeIngresso(body.getDataDeIngresso());
        aluno.setCep(body.getCep());
        aluno.setLogradouro(body.getLogradouro());
        aluno.setNumero(body.getNumero());
        aluno.setCidade(body.getCidade());
        aluno.setUf(body.getUf());

        alunoRepositorio.save(aluno);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarAluno(@PathVariable Long id){
        alunoRepositorio.deleteById(id);
    }
}
