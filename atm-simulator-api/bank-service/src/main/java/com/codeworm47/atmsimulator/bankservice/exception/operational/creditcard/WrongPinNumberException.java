package com.codeworm47.atmsimulator.bankservice.exception.operational.creditcard;

import com.codeworm47.atmsimulator.bankservice.exception.operational.OperationalException;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;

public class WrongPinNumberException extends OperationalException {
    private String creditCardNumber;
    private CreditCard creditCard;
    private String pinNumber;
    public WrongPinNumberException(String operationName, String exceptionCode, String creditCardNumber, String pinNumber, CreditCard creditCard) {
        super(String.format("Entered pin number %s for credit card number %s is wrong", creditCardNumber, pinNumber),
                operationName, exceptionCode);
        this.creditCardNumber = creditCardNumber;
        this.creditCard = creditCard;
        this.pinNumber = pinNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
