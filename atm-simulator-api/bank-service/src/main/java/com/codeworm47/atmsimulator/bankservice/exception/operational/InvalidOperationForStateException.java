package com.codeworm47.atmsimulator.bankservice.exception.operational;

import java.util.List;

public class InvalidOperationForStateException extends OperationalException {
    String entityType;
    String entityId;
    String entityState;
    String allowedStates;

    public InvalidOperationForStateException(String operationName, String exceptionCode, String entityType,
                                             String entityId, String entityState,
                                             String allowedStates) {
        super(String.format("operation %s is not allowed on %s with state %s (id : %s). " +
                "allowed states : %s", operationName, entityType, entityState, entityId, allowedStates),
                operationName, exceptionCode);
    }
}
