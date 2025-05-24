package com.example.apirest.Excepciones;

public class SolicitudCerrada extends RuntimeException {
    public SolicitudCerrada(String mensaje){
        super(mensaje);
    }
}
