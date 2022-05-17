package com.smartclide.dbapi.repository;

import com.smartclide.dbapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
