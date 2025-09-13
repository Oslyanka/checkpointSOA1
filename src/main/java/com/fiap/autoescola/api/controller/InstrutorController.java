package com.fiap.autoescola.api.controller;

import com.fiap.autoescola.api.dto.*;
import com.fiap.autoescola.domain.service.InstrutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/instrutores") @RequiredArgsConstructor
public class InstrutorController {
  private final InstrutorService service;

  @PostMapping @ResponseStatus(HttpStatus.CREATED)
  public InstrutorResponseDTO criar(@Valid @RequestBody InstrutorRequestDTO in) {
    return service.criar(in);
  }

  @GetMapping
  public List<InstrutorResponseDTO> listar() {
    return service.listar();
  }
}
