package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
}
