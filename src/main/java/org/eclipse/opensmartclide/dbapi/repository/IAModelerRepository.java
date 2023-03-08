package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.IAModeler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAModelerRepository extends MongoRepository<IAModeler, String> {
}
