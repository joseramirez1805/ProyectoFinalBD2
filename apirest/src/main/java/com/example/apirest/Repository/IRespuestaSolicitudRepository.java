package com.example.apirest.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apirest.Model.RespuestaSolicitudModel;

public interface IRespuestaSolicitudRepository extends MongoRepository<RespuestaSolicitudModel, ObjectId>{
    
}
