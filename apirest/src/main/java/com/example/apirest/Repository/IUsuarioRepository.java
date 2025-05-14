package com.example.apirest.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apirest.Model.UsuarioModel;

public interface IUsuarioRepository extends MongoRepository<UsuarioModel, ObjectId>{
    Optional<UsuarioModel> findByNumeroDocumento(String numeroDeDocumento);
    Optional<UsuarioModel> findByEmail(String email);
}
