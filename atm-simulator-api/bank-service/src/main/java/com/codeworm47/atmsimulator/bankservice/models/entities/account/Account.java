package com.codeworm47.atmsimulator.bankservice.models.entities.account;

import com.codeworm47.atmsimulator.bankservice.models.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.models.entities.EntityRef;
import com.codeworm47.atmsimulator.bankservice.models.entities.TimeStampCapable;

import java.util.Date;

public class Account extends BaseEntity implements TimeStampCapable {
    private Date createdDate;
    private Date lastModifiedDate;

    private String accountId;
    private String  name;
    private String type;
    private AccountStatus status;
    private Double balance;
    private EntityRef userRef;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public EntityRef getUserRef() {
        return userRef;
    }

    public void setUserRef(EntityRef userRef) {
        this.userRef = userRef;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
