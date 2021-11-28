package com.codeworm47.atmsimulator.bankservice.persistence;

import com.codeworm47.atmsimulator.bankservice.model.entities.user.LoginAttempt;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.LoginAttemptStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface LoginAttemptRepository extends MongoRepository<LoginAttempt, String> {
    long countByCreditCardIdAndStatusAndDate_Day(String creditCardId, LoginAttemptStatus status, Date date);
}
