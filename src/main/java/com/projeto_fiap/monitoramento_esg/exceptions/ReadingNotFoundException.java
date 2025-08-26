package com.projeto_fiap.monitoramento_esg.exceptions;

public class ReadingNotFoundException extends RuntimeException {
    public ReadingNotFoundException(String message) {
        super(message);
    }
}
