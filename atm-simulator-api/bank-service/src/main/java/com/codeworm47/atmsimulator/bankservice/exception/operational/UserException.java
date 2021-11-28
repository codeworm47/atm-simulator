package com.codeworm47.atmsimulator.bankservice.exception.operational;

public class UserException extends OperationalException {
    private String userId;
    public UserException(String message, String operationName, String exceptionCode, String userId) {
        super(message, operationName, exceptionCode);
        this.userId = userId;
    }
}
