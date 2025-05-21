package com.example.apirest.Excepciones;

public class SolicitudNoEncontrada extends RuntimeException {
    public SolicitudNoEncontrada(String mensaje){
        super(mensaje);
    }
}
