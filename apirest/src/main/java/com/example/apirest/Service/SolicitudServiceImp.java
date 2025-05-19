package com.example.apirest.Service;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.Model.SolicitudModel;
import com.example.apirest.Repository.ISolicitudRepository;

@Service
public class SolicitudServiceImp implements ISolicitudService{

    @Autowired
    ISolicitudRepository solicitudRepository;

    @Override
    public String crearSolicitud(SolicitudModel solicitud) {
        Date now = new Date();
        solicitud.setFechaCreacion(now);
        solicitud.setFechaUltimaActualizacion(now);
        solicitudRepository.save(solicitud);
        return "La solicitud fue creada con éxito.";
    }

    @Override
    public SolicitudModel buscarSolicitud(ObjectId id) {
        return solicitudRepository.findById(id).orElseThrow(null);
    }

    @Override
    public SolicitudModel actualizarSolicitud(ObjectId id, SolicitudModel solicitud) {
        SolicitudModel solicitudExistente = buscarSolicitud(id);
        solicitudExistente.setDescripcionDetallada(solicitud.getDescripcionDetallada());
        solicitudExistente.setFechaUltimaActualizacion(new Date());
        return solicitudRepository.save(solicitudExistente);
    }

    @Override
    public String eliminarSolicitud(ObjectId id) {
        SolicitudModel solicitud = solicitudRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con el id: " + id));
        solicitudRepository.delete(solicitud);
        return "La solicitud fue eliminada con éxito.";
    }

    
}
