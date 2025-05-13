package com.example.apirest.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Replica {
    @Id
    @JsonSerialize(using = ToStringSerializer.class) 
    private ObjectId idUsuario;
    private String comentarioReplica;
    private String oficio;
}
