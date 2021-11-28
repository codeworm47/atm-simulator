package com.codeworm47.atmsimulator.bankservice.model.dto.operation;

public class BalanceOperationResult extends OperationResult {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
