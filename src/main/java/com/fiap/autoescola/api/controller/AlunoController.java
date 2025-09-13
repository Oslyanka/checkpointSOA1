package com.fiap.autoescola.api.controller;

import com.fiap.autoescola.api.dto.*;
import com.fiap.autoescola.domain.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/alunos") @RequiredArgsConstructor
public class AlunoController {
  private final AlunoService service;

  @PostMapping @ResponseStatus(HttpStatus.CREATED)
  public AlunoResponseDTO criar(@Valid @RequestBody AlunoRequestDTO in) {
    return service.criar(in);
  }

  @GetMapping
  public List<AlunoResponseDTO> listar() {
    return service.listar();
  }
}
