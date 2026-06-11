package br.com.desafio.cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CursoCreate(
        @NotBlank @Size(min = 3) String name,
        @NotBlank @Size(min = 3) String category,
        @NotBlank @Size(min = 3) String teacher
) {
}
