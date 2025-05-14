package com.example.apirest.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.Excepciones.UsuarioYaExistente;
import com.example.apirest.Model.UsuarioModel;
import com.example.apirest.Repository.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
    @Autowired IUsuarioRepository usuarioRepository;
    @Override
    public String crearUsuario(UsuarioModel usuario) {
        UsuarioModel usuarioEncontradoPorDocumento  = buscarUsuarioPorNumeroDeDocumento(usuario.getNumeroDocumento());
        UsuarioModel usuarioEncontradoPorEmail = buscarUsuarioPorEmail(usuario.getDatosContacto().getEmail());
        
        if(usuarioEncontradoPorDocumento != null){
            throw new UsuarioYaExistente("El usuario con el documento: " + usuario.getNumeroDocumento() + " Ya existe");
        }

        if(usuarioEncontradoPorEmail != null){
            throw new UsuarioYaExistente("El usuario con el email: " + usuario.getDatosContacto().getEmail() + " Ya existe");
        }
        usuarioRepository.save(usuario);
        return "El usuario " + usuario.getNombreCompleto() + " Fue registrado con exito";
    }
        
    @Override
    public UsuarioModel buscarUsuarioPorId (ObjectId id){
        return usuarioRepository.findById(id).orElseThrow(null);

    }

    @Override
    public UsuarioModel actualizarUsuario (ObjectId id, UsuarioModel usuario){
        UsuarioModel usuarioABuscar = buscarUsuarioPorId(id);
        usuarioABuscar.setNombreCompleto(usuario.getNombreCompleto());
        usuarioABuscar.setDatosContacto(usuario.getDatosContacto());
        usuarioABuscar.setDireccionUnidadResidencial(usuario.getDireccionUnidadResidencial());
        return usuarioRepository.save(usuarioABuscar);
    }

    @Override
    public String eliminarUsuario (ObjectId id){
        UsuarioModel usuarioABuscar = buscarUsuarioPorId(id);
        String nombre = usuarioABuscar.getNombreCompleto();
        usuarioRepository.delete(usuarioABuscar);
        return "El usuario " + nombre + " Fue eliminado con exito";
    }

    @Override
    public UsuarioModel buscarUsuarioPorNumeroDeDocumento(String numeroDeDocumento) {
        Optional<UsuarioModel> usuario = usuarioRepository.findByNumeroDocumento(numeroDeDocumento);
        return usuario.orElse(null);
    }

    @Override
    public UsuarioModel buscarUsuarioPorEmail(String email) {
        Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);
        return usuario.orElse(null);
    }
}
