package com.example.apirest.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodosAdministracion {
    private Date fechaInicio;
    private Date fechaFin;
}
