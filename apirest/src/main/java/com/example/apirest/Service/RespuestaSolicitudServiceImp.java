package com.example.apirest.Service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.Excepciones.RespuestaSolicitudNoEncontrada;
import com.example.apirest.Excepciones.SolicitudNoEncontrada;
import com.example.apirest.Excepciones.UsuarioYaExistente;
import com.example.apirest.Model.Replica;
import com.example.apirest.Model.RespuestaSolicitudModel;
import com.example.apirest.Model.SolicitudModel;
import com.example.apirest.Model.UsuarioModel;
import com.example.apirest.Model.ENUMS.enumsUsuario;
import com.example.apirest.Model.ENUMS.estadoSolicitud;
import com.example.apirest.Repository.IRespuestaSolicitudRepository;
import com.example.apirest.Repository.ISolicitudRepository;
import com.example.apirest.Repository.IUsuarioRepository;

@Service
public class RespuestaSolicitudServiceImp implements IRespuestaSolicitudService {

    @Autowired IRespuestaSolicitudRepository respuestaSolicitudRepositorio;
    @Autowired ISolicitudRepository solicitudRepositorio;
    @Autowired IUsuarioRepository usuarioRepositorio;

    @Override
    public UsuarioModel buscarUsuario(ObjectId idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    @Override
    public SolicitudModel buscarSolicitud(ObjectId idSolicitud) {
        return solicitudRepositorio.findById(idSolicitud).orElse(null);
    }
    
    @Override
    public RespuestaSolicitudModel buscarRespuestaSolicitud(ObjectId id) {
        return respuestaSolicitudRepositorio.findById(id).orElse(null);
    }

    @Override
    public RespuestaSolicitudModel crearRespuestaSolicitud(RespuestaSolicitudModel respuesta) {
        UsuarioModel usuarioEncontrado = buscarUsuario(respuesta.getIdUsuario());
        if(usuarioEncontrado.getTipoUsuario() != enumsUsuario.Administrador){
            throw new UsuarioYaExistente("No eres administrador, no puedes responder peticiones");
        }
        if(buscarSolicitud(respuesta.getIdSolicitud()) == null){
            throw new SolicitudNoEncontrada("No se encontro la solicitud");
        }
        if(buscarUsuario(respuesta.getIdUsuario()) == null){
            throw new UsuarioYaExistente("No se encontro el usuario");
        }
        SolicitudModel solicitudEncontrada = buscarSolicitud(respuesta.getIdSolicitud());
        solicitudEncontrada.setEstadoSolicitud(estadoSolicitud.Resuelta);
        solicitudRepositorio.save(solicitudEncontrada);
        respuestaSolicitudRepositorio.save(respuesta);
        return respuesta;
    }

    @Override
    public Replica hacerReplicaRespuestaSolicitud(ObjectId id,RespuestaSolicitudModel replica) {
        System.out.println("Datos:" + replica);
        RespuestaSolicitudModel respuestaEncontrada = buscarRespuestaSolicitud(id);
        if(respuestaEncontrada == null){    
            throw new RespuestaSolicitudNoEncontrada("No se encontro respuesta a la cual hacer responder");
        }
        for(int i = 0; i < replica.getReplica().size(); i++){
            if(buscarUsuario(replica.getReplica().get(i).getIdUsuario()) == null){
                throw new UsuarioYaExistente("El usuario que intenta responder no existe");
            }
            respuestaEncontrada.getReplica().add(replica.getReplica().get(i));
            SolicitudModel solicitudEncontrada = buscarSolicitud(respuestaEncontrada.getIdSolicitud());
            solicitudEncontrada.setEstadoSolicitud(estadoSolicitud.Reabierta);
            solicitudRepositorio.save(solicitudEncontrada);
            respuestaSolicitudRepositorio.save(respuestaEncontrada);
            
        }
        return replica.getReplica().get(0);
    }

    @Override
    public String calificarRespuesta(ObjectId id,RespuestaSolicitudModel respuestaConCalificacion) {
        RespuestaSolicitudModel respuestaEncontrada = buscarRespuestaSolicitud(id);
        UsuarioModel usuarioEncontrado = buscarUsuario(respuestaConCalificacion.getIdUsuario());
        if(usuarioEncontrado == null){
            throw new UsuarioYaExistente("No se encontro el usuario");
        }
        if(respuestaEncontrada == null){    
            throw new RespuestaSolicitudNoEncontrada("No se encontro respuesta a la cual calificar");
        }
        respuestaEncontrada.setCalificacion(respuestaConCalificacion.getCalificacion());
        respuestaSolicitudRepositorio.save(respuestaEncontrada);
        return "Has hecho una calificacion a la respuesta hecha por: " + usuarioEncontrado.getNombreCompleto();
    }

}
