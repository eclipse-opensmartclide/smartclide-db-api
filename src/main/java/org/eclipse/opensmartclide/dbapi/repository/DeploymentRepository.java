package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.Deployment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeploymentRepository extends MongoRepository<Deployment, String> {
}
