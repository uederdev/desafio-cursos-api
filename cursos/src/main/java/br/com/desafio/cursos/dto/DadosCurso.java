package br.com.desafio.cursos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosCurso(
        UUID id,
        String name,
        String category,
        String teacher,
        Boolean active,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime createdAt
) {
}
