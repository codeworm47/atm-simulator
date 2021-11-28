package com.codeworm47.atmsimulator.bankservice.persistence;

import com.codeworm47.atmsimulator.bankservice.model.entities.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{ 'identificationInfo.value' : ?0}")
    User findByNationalId(String nationalId);
}
