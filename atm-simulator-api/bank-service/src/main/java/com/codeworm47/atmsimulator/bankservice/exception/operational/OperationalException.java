package com.codeworm47.atmsimulator.bankservice.exception.operational;

public class OperationalException extends RuntimeException {
    private String operationName;
    private String exceptionCode;
//    private String userId;
//    private String accountId;
//    private String creditCardId;

    public OperationalException(String message, String operationName, String exceptionCode){
        super(message);
        this.operationName = operationName;
        this.exceptionCode = exceptionCode;
    }

//    public OperationalException(String message, String operationName, String userId){
//        this(message, operationName);
//        this.userId = userId;
//    }
//
//    public OperationalException(String message, String operationName, String userId,String accountId){
//        this(message, operationName, userId);
//    }



}
