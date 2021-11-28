package com.codeworm47.atmsimulator.bankservice.persistence;

import com.codeworm47.atmsimulator.bankservice.model.entities.account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
