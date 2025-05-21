package com.example.apirest.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("BUSCAR/{id}")
    public ResponseEntity<UsuarioModel> buscarUsuarioPorId(@PathVariable ObjectId id){
        return new ResponseEntity<UsuarioModel>(usuarioService.buscarUsuarioPorId(id),HttpStatus.OK);
    }

    @PutMapping("ACTUALIZAR/{id}")
    public ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable ObjectId id, @RequestBody UsuarioModel usuario){
        return new ResponseEntity<UsuarioModel>(usuarioService.actualizarUsuario(id, usuario),HttpStatus.OK);
    }

    @DeleteMapping("ELIMINAR/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable ObjectId id){
        return new ResponseEntity<String>(usuarioService.eliminarUsuario(id),HttpStatus.OK);
    }
}
