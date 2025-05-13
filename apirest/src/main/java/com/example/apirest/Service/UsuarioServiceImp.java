package com.example.apirest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.Model.UsuarioModel;
import com.example.apirest.Repository.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
    @Autowired IUsuarioRepository usuarioRepository;
    @Override
    public String crearUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        return "El usuario " + usuario.getNombreCompleto() + "Fue registrado con exito";
    }
    
}
