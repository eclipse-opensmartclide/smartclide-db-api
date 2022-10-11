package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.ServiceRegistry;

public interface ServiceRegistryRepository extends MongoRepository<ServiceRegistry, String> {
}
