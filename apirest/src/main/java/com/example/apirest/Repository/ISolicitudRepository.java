package com.example.apirest.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apirest.Model.SolicitudModel;

public interface ISolicitudRepository extends MongoRepository<SolicitudModel, ObjectId>{
    
}
