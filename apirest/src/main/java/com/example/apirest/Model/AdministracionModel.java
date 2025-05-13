package com.example.apirest.Model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.apirest.Model.ENUMS.estadoAdministracion;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Administracion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministracionModel {
    @Id 
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId idUsuario;
    private estadoAdministracion estado;
    private List<PeriodosAdministracion> periodos; 
}
