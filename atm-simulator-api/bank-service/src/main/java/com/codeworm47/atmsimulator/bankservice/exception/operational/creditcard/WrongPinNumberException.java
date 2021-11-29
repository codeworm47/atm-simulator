package com.codeworm47.atmsimulator.bankservice.exception.operational.creditcard;

import com.codeworm47.atmsimulator.bankservice.exception.operational.OperationalException;

public class WrongPinNumberException extends OperationalException {

    public WrongPinNumberException(String operationName, String exceptionCode, String creditCardNumber, String pinNumber) {
        super(String.format("Entered pin number %s for credit card number %s is wrong", creditCardNumber, pinNumber),
                operationName, exceptionCode);
    }
}
