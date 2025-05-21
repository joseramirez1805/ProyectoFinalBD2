package com.example.apirest.Service;

import org.bson.types.ObjectId;

import com.example.apirest.Model.Replica;
import com.example.apirest.Model.RespuestaSolicitudModel;
import com.example.apirest.Model.SolicitudModel;
import com.example.apirest.Model.UsuarioModel;

public interface IRespuestaSolicitudService {
    public UsuarioModel buscarUsuario(ObjectId idUsuario);
    public SolicitudModel buscarSolicitud(ObjectId idSolicitud);
    public RespuestaSolicitudModel buscarRespuestaSolicitud(ObjectId id);
    public RespuestaSolicitudModel crearRespuestaSolicitud(RespuestaSolicitudModel respuesta);
    public Replica hacerReplicaRespuestaSolicitud(RespuestaSolicitudModel replica);
    public String calificarRespuesta(RespuestaSolicitudModel respuestaConCalificacion);
}