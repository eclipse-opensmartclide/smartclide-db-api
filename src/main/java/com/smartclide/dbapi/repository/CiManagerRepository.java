package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.CiManager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CiManagerRepository extends MongoRepository<CiManager, String> {
}
