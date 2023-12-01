package com.foragpt.escolaparaelas.repositorio;

import com.foragpt.escolaparaelas.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {
}
