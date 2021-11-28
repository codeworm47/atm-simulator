package com.codeworm47.atmsimulator.bankservice.persistence;

import com.codeworm47.atmsimulator.bankservice.model.entities.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
