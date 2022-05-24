package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.ServiceRegistry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceRegistryRepository extends MongoRepository<ServiceRegistry, String> {
}
