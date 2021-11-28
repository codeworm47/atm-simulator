package com.codeworm47.atmsimulator.bankservice.persistence;

import com.codeworm47.atmsimulator.bankservice.model.entities.user.LoginAttempt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginAttemptRepository extends MongoRepository<LoginAttempt, String> {
}
