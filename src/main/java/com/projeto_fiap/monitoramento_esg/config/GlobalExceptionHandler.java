package com.projeto_fiap.monitoramento_esg.config;

import com.projeto_fiap.monitoramento_esg.exceptions.AlertNotFoundException;
import com.projeto_fiap.monitoramento_esg.exceptions.SensorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SensorNotFoundException.class)
    public ResponseEntity<String> handleSensorNotFound(SensorNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
        String error = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .findFirst()
                .orElse("Erro de validação.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AlertNotFoundException.class)
    public Map<String, Object> handleAlertNotFound(AlertNotFoundException ex) {
        return Map.of("error", "Not Found", "message", ex.getMessage());
    }
}
