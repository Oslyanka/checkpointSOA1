package com.fiap.autoescola.api.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, Object> handleValidation(MethodArgumentNotValidException ex) {
    var errors = ex.getBindingResult().getFieldErrors().stream()
      .map(e -> Map.of("field", e.getField(), "message", e.getDefaultMessage()))
      .toList();
    return Map.of("status", 400, "errors", errors);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public Map<String, Object> handleBusiness(IllegalArgumentException ex) {
    return Map.of("status", 422, "error", ex.getMessage());
  }
}
