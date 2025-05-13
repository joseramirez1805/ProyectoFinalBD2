package com.example.apirest.Model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("RespuestaSolicitud")
public class RespuestaSolicitud {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId idSolicitud;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId idUsuario;
    private Integer calificacion;
    private String comentario;
    private ArrayList<Replica> replica = new ArrayList<Replica>();
}
