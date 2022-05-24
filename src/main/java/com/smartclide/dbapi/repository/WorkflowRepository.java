package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.Workflow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkflowRepository extends MongoRepository<Workflow, String> {
}
