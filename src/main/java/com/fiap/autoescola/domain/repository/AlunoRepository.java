package com.fiap.autoescola.domain.repository;

import com.fiap.autoescola.domain.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
  boolean existsByEmail(String email);
  boolean existsByCpf(String cpf);
}
