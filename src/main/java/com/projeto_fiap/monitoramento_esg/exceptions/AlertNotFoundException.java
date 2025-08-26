package com.projeto_fiap.monitoramento_esg.exceptions;

public class AlertNotFoundException extends RuntimeException {
    public AlertNotFoundException(String message) {
        super(message);
    }
}
