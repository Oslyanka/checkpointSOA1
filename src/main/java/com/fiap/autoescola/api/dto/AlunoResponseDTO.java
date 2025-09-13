package com.fiap.autoescola.api.dto;

public record AlunoResponseDTO(
  Long id,
  String nome,
  String email,
  String telefone,
  String cpf
) {}
