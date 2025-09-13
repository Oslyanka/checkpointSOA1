package com.fiap.autoescola.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "aluno")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Aluno {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 120)
  private String nome;

  @Column(nullable = false, length = 120, unique = true)
  private String email;

  @Column(nullable = false, length = 20)
  private String telefone;

  @Column(nullable = false, length = 14, unique = true)
  private String cpf;
}
