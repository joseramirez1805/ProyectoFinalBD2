package com.example.apirest.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apirest.Model.AdministracionModel;

public interface IAdministracionRepository extends MongoRepository<AdministracionModel, ObjectId>{
    
}
