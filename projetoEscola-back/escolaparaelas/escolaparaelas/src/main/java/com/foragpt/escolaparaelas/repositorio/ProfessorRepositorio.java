package com.foragpt.escolaparaelas.repositorio;

import com.foragpt.escolaparaelas.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepositorio extends JpaRepository<Professor, Long> {
}
