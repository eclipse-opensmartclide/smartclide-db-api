package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.ServiceRegistry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceRegistryRepository extends MongoRepository<ServiceRegistry, String> {
}
