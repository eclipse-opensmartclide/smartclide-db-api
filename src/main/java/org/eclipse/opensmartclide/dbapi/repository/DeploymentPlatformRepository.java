package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.DeploymentPlatform;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeploymentPlatformRepository extends MongoRepository<DeploymentPlatform, String> {
}
