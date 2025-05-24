package com.example.apirest.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.Model.Replica;
import com.example.apirest.Model.RespuestaSolicitudModel;
import com.example.apirest.Service.IRespuestaSolicitudService;

@RestController
@RequestMapping("/API/PQRS/")
public class RespuestaSolicitudController {
    
    @Autowired IRespuestaSolicitudService respuestaSolicitudRepositorio;

    @PostMapping("CREAR-RESPUESTA-SOLICITUD")
    public ResponseEntity<RespuestaSolicitudModel> crearRespuestaSolicitudModel(@RequestBody RespuestaSolicitudModel respuesta){
        return new ResponseEntity<RespuestaSolicitudModel>(respuestaSolicitudRepositorio.crearRespuestaSolicitud(respuesta), HttpStatus.OK);
    }

    @PostMapping("HACER-REPLICA/{id}")
    public ResponseEntity<Replica> hacerReplicaRespuesta(@PathVariable ObjectId id,@RequestBody RespuestaSolicitudModel replica){
        return new ResponseEntity<Replica>(respuestaSolicitudRepositorio.hacerReplicaRespuestaSolicitud(id,replica), HttpStatus.OK);
    }

    @PostMapping("CALIFICAR-RESPUESTA/{id}")
    public ResponseEntity<String> calificarRespuesta(@PathVariable ObjectId id,@RequestBody RespuestaSolicitudModel respuestaConCalificacion){
        return new ResponseEntity<String>(respuestaSolicitudRepositorio.calificarRespuesta(id,respuestaConCalificacion), HttpStatus.OK);
    }

    @PutMapping("CERRAR-SOLICITUD/{id}")
    public ResponseEntity<String> cerrarSolicitud(@PathVariable ObjectId id){
        return new ResponseEntity<String>(respuestaSolicitudRepositorio.cerrarSolicitud(id), HttpStatus.OK);
    }
}
