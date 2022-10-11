package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.Workflow;

public interface WorkflowRepository extends MongoRepository<Workflow, String> {
}
