package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.Service;

import java.util.Date;
import java.util.List;

public interface ServiceRepository extends MongoRepository<Service, String> {
}
