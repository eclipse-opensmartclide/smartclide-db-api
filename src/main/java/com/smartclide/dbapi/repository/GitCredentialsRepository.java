package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.GitCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GitCredentialsRepository extends MongoRepository<GitCredentials, String> {
}
