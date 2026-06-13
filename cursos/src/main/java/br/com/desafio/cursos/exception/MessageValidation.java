package br.com.desafio.cursos.exception;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MessageValidation(
        @NotBlank String message,
        @NotNull LocalDateTime dateTime) {
}
