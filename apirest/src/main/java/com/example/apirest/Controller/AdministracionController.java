package com.example.apirest.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.Model.AdministracionModel;
import com.example.apirest.Service.IAdministracionService;

@RestController
@RequestMapping("/API/PQRS/")
public class AdministracionController {
    @Autowired IAdministracionService administracionService;
    
    @PostMapping("ADMINISTRACION/CREAR")
    public ResponseEntity<String> crearAdministracion(@RequestBody AdministracionModel administracion){
        return new ResponseEntity<String>(administracionService.crearAdministracion(administracion),HttpStatus.CREATED);
    }

    @PostMapping("ACTUALIZAR-ADMINISTRACION/{id}")
    public ResponseEntity<String> actualizarAdministracion(@PathVariable ObjectId id, @RequestBody AdministracionModel administracionNueva){
        return new ResponseEntity<String>(administracionService.cambiarDeAdministracion(id, administracionNueva), HttpStatus.OK);
    }
    
}
