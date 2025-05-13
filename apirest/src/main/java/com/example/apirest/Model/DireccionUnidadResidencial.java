package com.example.apirest.Model;

import com.example.apirest.Model.ENUMS.TipoInmueble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionUnidadResidencial {
    private TipoInmueble tipoInmueble;
    private Integer numeroInmueble;
}
