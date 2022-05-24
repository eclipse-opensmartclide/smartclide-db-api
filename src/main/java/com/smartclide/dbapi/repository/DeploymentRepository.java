package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.Deployment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeploymentRepository extends MongoRepository<Deployment, String> {
}
