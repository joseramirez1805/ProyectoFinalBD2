package com.example.apirest.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.apirest.Model.ENUMS.enumsUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {
    @Id
    private ObjectId id;
    private enumsUsuario tipoUsuario;
    private String nombreCompleto;
    private String tipoDocumento;
    private String numeroDocumento;
    private datosContacto datosContacto;
    private String direccionUnidadResidencial;
}
