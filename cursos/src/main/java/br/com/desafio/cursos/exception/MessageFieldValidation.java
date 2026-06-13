package br.com.desafio.cursos.exception;

import java.time.LocalDateTime;

public record MessageFieldValidation(String field, String message, LocalDateTime data) {

}
