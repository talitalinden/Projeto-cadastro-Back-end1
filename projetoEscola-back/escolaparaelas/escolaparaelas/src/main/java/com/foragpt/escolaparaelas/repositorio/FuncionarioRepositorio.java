package com.foragpt.escolaparaelas.repositorio;

import com.foragpt.escolaparaelas.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
}
