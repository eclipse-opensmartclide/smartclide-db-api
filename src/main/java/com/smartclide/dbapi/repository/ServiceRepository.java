package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ServiceRepository extends MongoRepository<Service, String> {
    List<Service> findByCreatedGreaterThan(Date date);
}
