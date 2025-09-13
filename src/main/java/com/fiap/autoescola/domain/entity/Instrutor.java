package com.fiap.autoescola.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "instrutor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Instrutor {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 120)
  private String nome;

  @Column(nullable = false, length = 120, unique = true)
  private String email;

  @Column(nullable = false, length = 20)
  private String telefone;

  @Column(name = "cnh_categoria", nullable = false, length = 3)
  private String cnhCategoria;
}
