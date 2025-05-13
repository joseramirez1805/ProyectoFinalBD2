package com.example.apirest.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class datosContacto {
    private String email;
    private String numeroTelefono;
}
