package com.example.apirest.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evidencias {
    private String tipoArchivo;
    private String descripcion;
    private Date fechaCarga;
    private Date horaCarga;
}
