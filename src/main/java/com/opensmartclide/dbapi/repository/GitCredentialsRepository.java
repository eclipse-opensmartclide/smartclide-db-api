package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.GitCredentials;

public interface GitCredentialsRepository extends MongoRepository<GitCredentials, String> {
}
