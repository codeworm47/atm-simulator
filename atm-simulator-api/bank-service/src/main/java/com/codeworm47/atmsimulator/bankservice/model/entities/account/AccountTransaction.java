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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AccountTransactionType getType() {
        return type;
    }

    public void setType(AccountTransactionType type) {
        this.type = type;
    }

    public AccountTransactionStatus getStatus() {
        return status;
    }

    public void setStatus(AccountTransactionStatus status) {
        this.status = status;
    }

    public EntityRef getAccountRef() {
        return accountRef;
    }

    public void setAccountRef(EntityRef accountRef) {
        this.accountRef = accountRef;
    }

    public EntityRef getCreditCardRef() {
        return creditCardRef;
    }

    public void setCreditCardRef(EntityRef creditCardRef) {
        this.creditCardRef = creditCardRef;
    }
}
