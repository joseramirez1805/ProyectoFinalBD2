package com.example.apirest.Excepciones;

public class AministracionExistente extends RuntimeException{
    public AministracionExistente(String mensaje){
        super(mensaje);
    }
}
