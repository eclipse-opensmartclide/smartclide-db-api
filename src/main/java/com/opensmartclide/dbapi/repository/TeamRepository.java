package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.Team;

public interface TeamRepository extends MongoRepository<Team, String> {
}
