package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
}
