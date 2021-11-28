package com.codeworm47.atmsimulator.bankservice.model.entities.account;

import com.codeworm47.atmsimulator.bankservice.model.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.model.entities.EntityRef;
import com.codeworm47.atmsimulator.bankservice.model.entities.TimeStampCapable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Account extends BaseEntity implements TimeStampCapable {
    private Date createdDate;
    private Date lastModifiedDate;
    @NotEmpty
    private String accountId;
    private String  name;
    private AccountStatus status;
    private Double balance;
    @NotNull
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
