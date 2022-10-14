package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.Workflow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkflowRepository extends MongoRepository<Workflow, String> {
}
