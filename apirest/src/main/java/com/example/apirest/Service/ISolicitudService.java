package com.example.apirest.Service;

import org.bson.types.ObjectId;

import com.example.apirest.Model.SolicitudModel;

public interface ISolicitudService {
    public String crearSolicitud(SolicitudModel solicitud);
    public SolicitudModel buscarSolicitud (ObjectId id);
    public SolicitudModel actualizarSolicitud(ObjectId id, SolicitudModel solicitud);
    public String eliminarSolicitud(ObjectId id);
    public String validarSolicitud(ObjectId id);
}
