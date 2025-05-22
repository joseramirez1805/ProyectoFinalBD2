package com.example.apirest.Service;

import org.bson.types.ObjectId;

import com.example.apirest.Model.AdministracionModel;
import com.example.apirest.Model.UsuarioModel;

public interface IAdministracionService {
    public UsuarioModel buscarUsuario(ObjectId id);
    public String crearAdministracion(AdministracionModel administracion);
}
