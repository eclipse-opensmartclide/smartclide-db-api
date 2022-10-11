package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.DeploymentPlatform;

public interface DeploymentPlatformRepository extends MongoRepository<DeploymentPlatform, String> {
}
