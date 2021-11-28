package com.codeworm47.atmsimulator.bankservice.model.entities.user;

import com.codeworm47.atmsimulator.bankservice.model.entities.BaseEntity;

import java.util.Date;

public class LoginAttempt extends BaseEntity {
    String creditCardNumber;
    String creditCardId;
    Date date;
    String ip;
    LoginAttemptStatus status;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LoginAttemptStatus getStatus() {
        return status;
    }

    public void setStatus(LoginAttemptStatus status) {
        this.status = status;
    }
}
