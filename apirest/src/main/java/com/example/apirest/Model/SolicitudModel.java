package com.example.apirest.Model;



import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.apirest.Model.ENUMS.estadoSolicitud;
import com.example.apirest.Model.ENUMS.tipoSolicitud;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Solicitud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudModel {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private tipoSolicitud tipo;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId idUsuarioRegistra;
    private String descripcionDetallada;
    private Date fechaCreacion; 
    private estadoSolicitud estadoSolcitud;
    private Date fechaUltimaActualizacion;
    private List<Evidencias> evidencias;
}
