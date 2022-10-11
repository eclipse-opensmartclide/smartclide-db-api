package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.CiManager;

public interface CiManagerRepository extends MongoRepository<CiManager, String> {
}
