package com.codeworm47.atmsimulator.bankservice.exception.logical;

public class ServiceImplementationNotfoundException extends LogicalException {
    private String serviceName;

    public ServiceImplementationNotfoundException(String message, String serviceName) {
        super(message);
        this.serviceName = serviceName;
    }
}
