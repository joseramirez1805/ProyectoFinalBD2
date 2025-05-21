package com.example.apirest.Excepciones;

public class RespuestaSolicitudNoEncontrada extends RuntimeException{
    public RespuestaSolicitudNoEncontrada(String mensaje){
        super(mensaje);
    }
}
