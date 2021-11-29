package com.codeworm47.atmsimulator.bankservice.model.dto.operation;

public class WithdrawDepositOperationResult extends OperationResult {
    String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
