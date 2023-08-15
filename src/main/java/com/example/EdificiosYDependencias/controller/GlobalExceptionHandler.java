package com.example.EdificiosYDependencias.controller;

import com.example.EdificiosYDependencias.util.Jsons;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        String mensajeError = ex.getMessage();

        return new ResponseEntity<>(Jsons.asJsonString(mensajeError), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
