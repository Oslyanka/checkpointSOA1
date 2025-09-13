package com.fiap.autoescola.domain.repository;

import com.fiap.autoescola.domain.entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
  boolean existsByEmail(String email);
}
