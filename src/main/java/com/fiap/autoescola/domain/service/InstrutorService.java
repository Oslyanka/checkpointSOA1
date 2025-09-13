package com.fiap.autoescola.domain.service;

import com.fiap.autoescola.api.dto.*;
import com.fiap.autoescola.domain.entity.Instrutor;
import com.fiap.autoescola.domain.repository.InstrutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor
public class InstrutorService {
  private final InstrutorRepository repo;

  @Transactional
  public InstrutorResponseDTO criar(InstrutorRequestDTO in) {
    if (repo.existsByEmail(in.email)) throw new IllegalArgumentException("Email já cadastrado");
    var e = Instrutor.builder()
        .nome(in.nome).email(in.email).telefone(in.telefone).cnhCategoria(in.cnhCategoria)
        .build();
    e = repo.save(e);
    return new InstrutorResponseDTO(e.getId(), e.getNome(), e.getEmail(), e.getTelefone(), e.getCnhCategoria());
  }

  @Transactional(readOnly = true)
  public List<InstrutorResponseDTO> listar() {
    return repo.findAll().stream()
      .map(e -> new InstrutorResponseDTO(e.getId(), e.getNome(), e.getEmail(), e.getTelefone(), e.getCnhCategoria()))
      .toList();
  }
}
