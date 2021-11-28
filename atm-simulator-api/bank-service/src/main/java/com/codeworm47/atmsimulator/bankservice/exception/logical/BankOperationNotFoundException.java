package com.codeworm47.atmsimulator.bankservice.exception.logical;

public class BankOperationNotFoundException extends ServiceImplementationNotfoundException {
    private String detailedMessage;
    private String operationParamsClassName;
    private String operationResultClassName;

    public BankOperationNotFoundException(String operationName) {
        super(String.format("invalid bank operation : %s", operationName), operationName);
        this.detailedMessage = String.format("no BankOperation implementation found for %s", operationName);
    }

    public BankOperationNotFoundException(String operationName, String operationParamsClassName, String operationResultClassName) {
        this(operationName);
        this.detailedMessage = String.format("couldn't find any BankOperation implementations for %s, %s and %s." +
                "There are BankOperation implementations for operation name %s " +
                "but with different params and result class type.", operationName,
                operationParamsClassName, operationResultClassName,operationName);
    }
}
