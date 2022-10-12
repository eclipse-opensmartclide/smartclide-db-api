package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.CiManager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CiManagerRepository extends MongoRepository<CiManager, String> {
}
