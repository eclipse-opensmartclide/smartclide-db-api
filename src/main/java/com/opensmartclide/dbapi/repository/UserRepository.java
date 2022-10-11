package com.opensmartclide.dbapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opensmartclide.dbapi.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
