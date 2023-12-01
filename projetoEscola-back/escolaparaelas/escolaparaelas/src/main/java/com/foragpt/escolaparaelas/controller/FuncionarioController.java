package com.foragpt.escolaparaelas.controller;

import com.foragpt.escolaparaelas.model.Funcionario;
import com.foragpt.escolaparaelas.repositorio.FuncionarioRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioController(FuncionarioRepositorio funcionarioRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioRepositorio.findAll();
    }

    @PostMapping
    public Long cadastrarFuncionario(@RequestBody FuncionarioRequestBody body) {

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(body.getNome());
        funcionario.setDataNascimento(body.getDataNascimento());
        funcionario.setTelefone(body.getTelefone());
        funcionario.setCep(body.getCep());
        funcionario.setLogradouro(body.getLogradouro());
        funcionario.setNumero(body.getNumero());
        funcionario.setCidade(body.getCidade());
        funcionario.setUf(body.getUf());
        funcionario.setCargo(body.getCargo());
        funcionario.setDataDeContratacao(body.getDataDeContratacao());

        return funcionarioRepositorio.save(funcionario).getId();
    }

    @PutMapping(path = "/{id}")
    public void atualizarFuncionario(@PathVariable ("id")Long id, @RequestBody FuncionarioRequestBody body){

        Funcionario funcionario = funcionarioRepositorio.getReferenceById(id);

        funcionario.setNome(body.getNome());
        funcionario.setDataNascimento(body.getDataNascimento());
        funcionario.setTelefone(body.getTelefone());
        funcionario.setCep(body.getCep());
        funcionario.setLogradouro(body.getLogradouro());
        funcionario.setNumero(body.getNumero());
        funcionario.setCidade(body.getCidade());
        funcionario.setUf(body.getUf());
        funcionario.setCargo(body.getCargo());
        funcionario.setDataDeContratacao(body.getDataDeContratacao());

        funcionarioRepositorio.save(funcionario);

    }

    @DeleteMapping(path = "/{id}")
    public void deletarFuncionario(@PathVariable Long id){
        funcionarioRepositorio.deleteById(id);
    }
}
