package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.Deployment;

public interface DeploymentRepository extends MongoRepository<Deployment, String> {
}
