package com.fiap.autoescola.domain.vo;

public record CpfVO(String value) {
  public CpfVO {
    if (value == null || !value.matches("\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
      throw new IllegalArgumentException("CPF inválido");
    }
  }
  public String normalized() {
    return value.replaceAll("\\D", "");
  }
}
