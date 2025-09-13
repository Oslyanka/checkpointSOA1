package com.fiap.autoescola.api.dto;

import jakarta.validation.constraints.*;

public class InstrutorRequestDTO {

  @NotBlank @Size(max = 120)
  public String nome;

  @NotBlank @Email @Size(max = 120)
  public String email;

  @NotBlank @Size(max = 20)
  public String telefone;

  @NotBlank @Size(max = 3)
  public String cnhCategoria;
}
