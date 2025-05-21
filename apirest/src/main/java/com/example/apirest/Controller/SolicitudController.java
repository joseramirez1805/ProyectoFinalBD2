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

import com.example.apirest.Model.SolicitudModel;
import com.example.apirest.Service.ISolicitudService;

@RestController
@RequestMapping("/API/PQRS/Solicitud/")
public class SolicitudController {
    @Autowired ISolicitudService solicitudService;

    @PostMapping("crearSolicitud")
    public ResponseEntity<String> crearSolicitud(@RequestBody SolicitudModel solicitud) {
        return new ResponseEntity<String> (solicitudService.crearSolicitud(solicitud), HttpStatus.CREATED);
    }

    @GetMapping("Buscar/{id}")
    public ResponseEntity<SolicitudModel> buscarSolicitud(@PathVariable ObjectId id) {
        return new ResponseEntity<SolicitudModel>(solicitudService.buscarSolicitud(id), HttpStatus.OK);
    }

    @PutMapping("Actualizar/{id}")
    public ResponseEntity<SolicitudModel> actualizarSolicitud(@PathVariable ObjectId id, @RequestBody SolicitudModel solicitud) {
        return new ResponseEntity<SolicitudModel>(solicitudService.actualizarSolicitud(id, solicitud), HttpStatus.OK);
    }

    @DeleteMapping("Eliminar/{id}")
    public ResponseEntity<String> eliminarSolicitud(@PathVariable ObjectId id) {
        return new ResponseEntity<String> (solicitudService.eliminarSolicitud(id), HttpStatus.OK);
    }
}
