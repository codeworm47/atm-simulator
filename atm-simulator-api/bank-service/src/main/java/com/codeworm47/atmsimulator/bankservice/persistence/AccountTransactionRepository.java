package com.codeworm47.atmsimulator.bankservice.persistence;

import com.codeworm47.atmsimulator.bankservice.model.entities.account.AccountTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountTransactionRepository extends MongoRepository<AccountTransaction, String> {
}
