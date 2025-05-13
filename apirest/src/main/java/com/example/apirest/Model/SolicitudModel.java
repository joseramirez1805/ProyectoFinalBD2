package com.example.apirest.Model;

import java.sql.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.example.apirest.Model.ENUMS.tipoSolicitud;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class SolicitudModel {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private tipoSolicitud tipo;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId idUsuarioRegistra;
    private String descripcionDetallada;
    private Date fechaCreacion; 
}
