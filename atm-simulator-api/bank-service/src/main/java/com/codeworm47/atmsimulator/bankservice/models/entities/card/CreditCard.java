package com.codeworm47.atmsimulator.bankservice.models.entities.card;

import com.codeworm47.atmsimulator.bankservice.models.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.models.entities.EntityRef;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreditCard extends BaseEntity {
    @NotNull
    private Date issuedDate;
    @NotEmpty
    //TODO find proper regex for cardId
    //@Pattern(regexp = "/^4[0-9]\\d+$/")
    private String cardId;
    private CreditCardStatus status;
    @NotEmpty
    private String hashedPin;
    @NotNull
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
