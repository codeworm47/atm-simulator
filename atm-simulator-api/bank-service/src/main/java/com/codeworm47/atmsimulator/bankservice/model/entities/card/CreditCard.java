package com.codeworm47.atmsimulator.bankservice.model.entities.card;

import com.codeworm47.atmsimulator.bankservice.model.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.model.entities.EntityRef;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class CreditCard extends BaseEntity {
    @NotNull
    private Date issuedDate;
    @NotEmpty
    @Pattern(regexp = "\\d+")
    @Size(min = 16, max = 20)
    @Indexed(unique = true)
    private String cardNumber;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
