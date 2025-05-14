package com.example.apirest.Excepciones;

public class UsuarioYaExistente extends RuntimeException {
    public UsuarioYaExistente(String mensaje){
        super(mensaje);
    }
}
