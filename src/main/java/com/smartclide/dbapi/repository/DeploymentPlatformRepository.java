package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.DeploymentPlatform;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeploymentPlatformRepository extends MongoRepository<DeploymentPlatform, String> {
}
