package com.codeworm47.atmsimulator.bankservice.model.dto;

import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;

public class TokenInputModel {
    UserAuthenticationMechanism authenticationMechanism;
    String cardNumber;
    String pinNumber;
    byte[] biometric;

    public TokenInputModel(UserAuthenticationMechanism authenticationMechanism, String cardNumber, String pinNumber) {
        this.authenticationMechanism = authenticationMechanism;
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
    }

    public TokenInputModel(UserAuthenticationMechanism authenticationMechanism, String cardNumber, byte[] biometric) {
        this.authenticationMechanism = authenticationMechanism;
        this.cardNumber = cardNumber;
        this.biometric = biometric;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public byte[] getBiometric() {
        return biometric;
    }

    public void setBiometric(byte[] biometric) {
        this.biometric = biometric;
    }

    public UserAuthenticationMechanism getAuthenticationMechanism() {
        return authenticationMechanism;
    }

    public void setAuthenticationMechanism(UserAuthenticationMechanism authenticationMechanism) {
        this.authenticationMechanism = authenticationMechanism;
    }
}
