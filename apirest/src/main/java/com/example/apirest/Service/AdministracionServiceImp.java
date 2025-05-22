package com.example.apirest.Service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.Excepciones.NoEsAdministrador;
import com.example.apirest.Excepciones.UsuarioNoEncontrado;
import com.example.apirest.Model.AdministracionModel;
import com.example.apirest.Model.UsuarioModel;
import com.example.apirest.Model.ENUMS.enumsUsuario;
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
    public String crearAdministracion(AdministracionModel administracion) {
        UsuarioModel usuarioEncontrado = buscarUsuario(administracion.getIdUsuario());
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

}