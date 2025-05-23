package com.example.apirest.Service;

import org.bson.types.ObjectId;

import com.example.apirest.Model.AdministracionModel;
import com.example.apirest.Model.UsuarioModel;

public interface IAdministracionService {
    public UsuarioModel buscarUsuario(ObjectId id);
    public AdministracionModel buscarAdministracion(ObjectId id);
    public AdministracionModel buscarAdministracionPorIdUsuario(ObjectId id);
    public String crearAdministracion(AdministracionModel administracion);
    public String cambiarDeAdministracion(ObjectId id, AdministracionModel administracion);
}
