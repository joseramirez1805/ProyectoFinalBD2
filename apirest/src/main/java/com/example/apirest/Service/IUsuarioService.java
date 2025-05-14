package com.example.apirest.Service;

import org.bson.types.ObjectId;

import com.example.apirest.Model.UsuarioModel;

public interface IUsuarioService {
    public String crearUsuario(UsuarioModel usuario);
    public UsuarioModel buscarUsuarioPorId (ObjectId id);
    public UsuarioModel actualizarUsuario (ObjectId id, UsuarioModel usuario);
    public String eliminarUsuario (ObjectId id);
}
