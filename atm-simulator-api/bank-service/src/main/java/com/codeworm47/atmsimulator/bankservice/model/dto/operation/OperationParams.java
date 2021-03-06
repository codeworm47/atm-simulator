package com.codeworm47.atmsimulator.bankservice.model.dto.operation;

import com.codeworm47.atmsimulator.bankservice.model.entities.account.Account;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;

public class OperationParams {
    private String creditCardNumber;
    private CreditCard creditCard;
    private Account account;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
