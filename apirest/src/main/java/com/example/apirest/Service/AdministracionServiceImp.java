package com.example.apirest.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.Excepciones.AministracionExistente;
import com.example.apirest.Excepciones.NoEsAdministrador;
import com.example.apirest.Excepciones.UsuarioNoEncontrado;
import com.example.apirest.Model.AdministracionModel;
import com.example.apirest.Model.UsuarioModel;
import com.example.apirest.Model.ENUMS.enumsUsuario;
import com.example.apirest.Model.ENUMS.estadoAdministracion;
import com.example.apirest.Repository.IAdministracionRepository;
import com.example.apirest.Repository.IUsuarioRepository;

@Service
public class AdministracionServiceImp implements IAdministracionService{
    @Autowired IUsuarioRepository usuarioRepositorio;
    @Autowired IAdministracionRepository administracionRepositoro;

    @Override
    public UsuarioModel buscarUsuario(ObjectId id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public AdministracionModel buscarAdministracion(ObjectId id) {
        return administracionRepositoro.findById(id).orElse(null);
    }

    @Override
    public AdministracionModel buscarAdministracionPorIdUsuario(ObjectId id) {
        Optional<AdministracionModel> administracionEncontrada = administracionRepositoro.findByIdUsuario(id);
        return administracionEncontrada.orElse(null);
    }

    @Override
    public String crearAdministracion(AdministracionModel administracion) {
        UsuarioModel usuarioEncontrado = buscarUsuario(administracion.getIdUsuario());
        AdministracionModel verificacionSiExiste = buscarAdministracionPorIdUsuario(administracion.getIdUsuario());
        if(verificacionSiExiste != null){
            throw new AministracionExistente("Estas intentando crear una administracion ya existente");
        }
        if(usuarioEncontrado == null){
            throw new UsuarioNoEncontrado("Usuario no existente o no encontrado");
        }
        if(usuarioEncontrado.getTipoUsuario() == enumsUsuario.Administrador){
            administracionRepositoro.save(administracion); 
        }else{
            throw new NoEsAdministrador("El usuario no es administrador");
        }
        return "El administrador ha sido creado";
    }

    @Override
    public String cambiarDeAdministracion(ObjectId id, AdministracionModel administracion) {
        UsuarioModel usuarioEncontrado = buscarUsuario(administracion.getIdUsuario());
        if(usuarioEncontrado.getTipoUsuario() != enumsUsuario.Administrador){
            throw new UsuarioNoEncontrado("El usuario con nombre: " +  usuarioEncontrado.getNombreCompleto() + " no puede hacer parte de la administracion");
        }
        
        AdministracionModel administracionEncontradaActualizar = buscarAdministracionPorIdUsuario(administracion.getIdUsuario());
        if(administracionEncontradaActualizar != null){
            administracionEncontradaActualizar.setEstado(estadoAdministracion.Activo);
            administracionEncontradaActualizar.getPeriodos().add(administracion.getPeriodos().get(0));
            administracionRepositoro.save(administracionEncontradaActualizar);
        }else{
            AdministracionModel administracionEncontrada = buscarAdministracion(id);
            administracionEncontrada.setEstado(estadoAdministracion.Inactivo);
            administracionRepositoro.save(administracionEncontrada);
            administracionRepositoro.save(administracion);
        }
        return "Administracion actualizada con exito";

    }
}