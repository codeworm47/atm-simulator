package com.codeworm47.atmsimulator.bankservice.model.dto;

import java.util.Date;

public class TokenOutputModel {
    String token;
    Date expiresAt;
    String CreditCardId;

    public TokenOutputModel(String token, Date expiresAt, String creditCardId) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.CreditCardId = creditCardId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getCreditCardId() {
        return CreditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        CreditCardId = creditCardId;
    }
}
