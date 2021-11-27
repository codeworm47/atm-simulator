package com.codeworm47.atmsimulator.bankservice.models.entities.card;

import com.codeworm47.atmsimulator.bankservice.models.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.models.entities.EntityRef;

import java.util.Date;

public class CreditCard extends BaseEntity {
    private Date issuedDate;
    private String cardId;
    private CreditCardStatus status;
    private String hashedPin;
    private EntityRef accountRef;

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public CreditCardStatus getStatus() {
        return status;
    }

    public void setStatus(CreditCardStatus status) {
        this.status = status;
    }

    public String getHashedPin() {
        return hashedPin;
    }

    public void setHashedPin(String hashedPin) {
        this.hashedPin = hashedPin;
    }

    public EntityRef getAccountRef() {
        return accountRef;
    }

    public void setAccountRef(EntityRef accountRef) {
        this.accountRef = accountRef;
    }
}
