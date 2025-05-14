package com.example.apirest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.apirest.Excepciones.UsuarioYaExistente;

@ControllerAdvice
public class UsuarioControllerAdvice {

    @ExceptionHandler(UsuarioYaExistente.class)
    public ResponseEntity<String> usuarioYaExistente(UsuarioYaExistente mensaje){
        return new ResponseEntity<String>(mensaje.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
