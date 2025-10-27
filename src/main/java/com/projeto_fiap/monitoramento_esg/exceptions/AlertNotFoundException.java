package com.projeto_fiap.monitoramento_esg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlertNotFoundException extends RuntimeException {
    public AlertNotFoundException(String msg) { super(msg); }
}

