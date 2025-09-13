package com.fiap.autoescola.domain.vo;

public record TelefoneVO(String value) {
  public TelefoneVO {
    if (value == null || value.replaceAll("\\D", "").length() < 10) {
      throw new IllegalArgumentException("Telefone inválido");
    }
  }
}
