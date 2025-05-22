package com.example.apirest.Excepciones;

public class UsuarioNoEncontrado extends RuntimeException {
    public UsuarioNoEncontrado(String mensaje){
        super(mensaje);
    }
}
