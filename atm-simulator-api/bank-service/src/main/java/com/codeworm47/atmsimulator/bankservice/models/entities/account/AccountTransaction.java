package com.codeworm47.atmsimulator.bankservice.models.entities.account;

import com.codeworm47.atmsimulator.bankservice.models.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.models.entities.EntityRef;

import java.util.Date;

public class AccountTransaction extends BaseEntity {
    String operation;
    private Date date;
    private AccountTransactionType type;
    private AccountTransactionStatus status;
    private EntityRef accountRef;
    private EntityRef creditCardRef;
}
