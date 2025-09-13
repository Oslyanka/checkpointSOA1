package com.fiap.autoescola.domain.service;

import com.fiap.autoescola.api.dto.*;
import com.fiap.autoescola.domain.entity.Aluno;
import com.fiap.autoescola.domain.repository.AlunoRepository;
import com.fiap.autoescola.domain.vo.CpfVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor
public class AlunoService {
  private final AlunoRepository repo;

  @Transactional
  public AlunoResponseDTO criar(AlunoRequestDTO in) {
    var cpf = new CpfVO(in.cpf).normalized();
    if (repo.existsByEmail(in.email)) throw new IllegalArgumentException("Email já cadastrado");
    if (repo.existsByCpf(cpf))       throw new IllegalArgumentException("CPF já cadastrado");
    var e = Aluno.builder()
      .nome(in.nome).email(in.email).telefone(in.telefone).cpf(cpf)
      .build();
    e = repo.save(e);
    return new AlunoResponseDTO(e.getId(), e.getNome(), e.getEmail(), e.getTelefone(), e.getCpf());
  }

  @Transactional(readOnly = true)
  public List<AlunoResponseDTO> listar() {
    return repo.findAll().stream()
      .map(e -> new AlunoResponseDTO(e.getId(), e.getNome(), e.getEmail(), e.getTelefone(), e.getCpf()))
      .toList();
  }
}
