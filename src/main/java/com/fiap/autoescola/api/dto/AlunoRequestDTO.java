package com.fiap.autoescola.api.dto;

import jakarta.validation.constraints.*;

public class AlunoRequestDTO {
  @NotBlank @Size(max = 120)
  public String nome;

  @NotBlank @Email @Size(max = 120)
  public String email;

  @NotBlank @Size(max = 20)
  public String telefone;

  @NotBlank @Size(max = 14)
  public String cpf;
}
