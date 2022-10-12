package org.eclipse.opensmartclide.dbapi.repository;

import org.eclipse.opensmartclide.dbapi.model.GitCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GitCredentialsRepository extends MongoRepository<GitCredentials, String> {
}
