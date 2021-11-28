package com.codeworm47.atmsimulator.bankservice.model.entities.account;

import com.codeworm47.atmsimulator.bankservice.model.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.model.entities.EntityRef;

import java.util.Date;

public class AccountTransaction extends BaseEntity {
    String operation;
    private Date date;
    private AccountTransactionType type;
    private AccountTransactionStatus status;
    private EntityRef accountRef;
    private EntityRef creditCardRef;
}
