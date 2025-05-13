package com.example.apirest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.Model.UsuarioModel;
import com.example.apirest.Service.IUsuarioService;

@RestController
@RequestMapping("/API/PQRS/")
public class UsuarioController {
    @Autowired 
    IUsuarioService usuarioService;

    @PostMapping("Crear")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioModel usuario){
        return new ResponseEntity<String>(usuarioService.crearUsuario(usuario),HttpStatus.CREATED);
    }
}
