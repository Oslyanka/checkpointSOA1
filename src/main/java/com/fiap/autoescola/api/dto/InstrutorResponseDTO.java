package com.fiap.autoescola.api.dto;

public record InstrutorResponseDTO(
  Long id,
  String nome,
  String email,
  String telefone,
  String cnhCategoria
) {}
