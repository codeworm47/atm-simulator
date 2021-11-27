package com.codeworm47.atmsimulator.bankservice.persistence;

import com.codeworm47.atmsimulator.bankservice.models.entities.account.AccountTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountTransactionRepository extends MongoRepository<AccountTransaction, String> {
}
