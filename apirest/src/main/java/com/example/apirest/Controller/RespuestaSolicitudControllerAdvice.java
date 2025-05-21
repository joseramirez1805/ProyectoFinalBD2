package com.example.apirest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.apirest.Excepciones.RespuestaSolicitudNoEncontrada;

@ControllerAdvice
public class RespuestaSolicitudControllerAdvice {
    @ExceptionHandler(RespuestaSolicitudNoEncontrada.class)
    public ResponseEntity<String> respuestaSolicitudNoEncontrada(RespuestaSolicitudNoEncontrada mensaje){
        return new ResponseEntity<String>(mensaje.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
