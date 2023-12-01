package com.foragpt.escolaparaelas.controller;

import com.foragpt.escolaparaelas.model.Funcionario;
import com.foragpt.escolaparaelas.model.Turma;
import com.foragpt.escolaparaelas.repositorio.TurmaRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/turmas")
public class TurmaController {

    private final TurmaRepositorio turmaRepositorio;

    public TurmaController(TurmaRepositorio turmaRepositorio) {
        this.turmaRepositorio = turmaRepositorio;
    }

    @GetMapping
    public List<Turma> findAll(){
        return turmaRepositorio.findAll();
    }

    @PostMapping
    public Turma cadastrarTurma(@RequestBody TurmaRequestBody body){
        Turma turma = new Turma();

        turma.setNome(body.getNome());

        return turmaRepositorio.save(turma);
    }

    @PutMapping(path = "/{id}")
    public void atualizarTurma(@PathVariable ("id")Long id, @RequestBody TurmaRequestBody body){

        Turma turma = turmaRepositorio.getReferenceById(id);

        turma.setNome(body.getNome());

        turmaRepositorio.save(turma);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarTurma(@PathVariable Long id){
        turmaRepositorio.deleteById(id);
    }

}
