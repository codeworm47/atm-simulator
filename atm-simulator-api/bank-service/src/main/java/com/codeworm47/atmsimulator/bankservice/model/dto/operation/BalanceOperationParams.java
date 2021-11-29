package com.codeworm47.atmsimulator.bankservice.model.dto.operation;

import com.codeworm47.atmsimulator.bankservice.model.entities.account.Account;

public class BalanceOperationParams extends OperationParams {
    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
