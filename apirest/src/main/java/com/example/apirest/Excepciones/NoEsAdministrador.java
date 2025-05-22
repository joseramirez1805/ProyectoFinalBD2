package com.example.apirest.Excepciones;

public class NoEsAdministrador extends RuntimeException {
    public NoEsAdministrador(String mensaje){
        super(mensaje);
    }
    
}
