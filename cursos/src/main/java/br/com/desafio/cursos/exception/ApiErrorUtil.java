package br.com.desafio.cursos.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ApiErrorUtil  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<List<MessageFieldValidation>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) throws Exception {
        List<MessageFieldValidation> fieldValidations = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> new MessageFieldValidation(x.getField(), x.getDefaultMessage(), LocalDateTime.now())).toList();
        return ResponseEntity.badRequest().body(fieldValidations);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<MessageValidation> handleDataIntegrityViolationException(DataIntegrityViolationException ex) throws Exception {
        MessageValidation errorMessage = new MessageValidation(ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<MessageValidation> handleException(Exception ex) throws Exception {
        MessageValidation errorMessage = new MessageValidation(ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
