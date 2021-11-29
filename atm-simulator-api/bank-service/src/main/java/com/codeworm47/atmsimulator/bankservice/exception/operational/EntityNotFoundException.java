package com.codeworm47.atmsimulator.bankservice.exception.operational;

import java.util.Map;

public class EntityNotFoundException extends OperationalException {
    private String entityType;
    private String entityId;
    private Map<String, Object> filters;

    public EntityNotFoundException(String operationName, String exceptionCode, String entityType, String entityId) {
        super(String.format("%s with id %s not found", entityType, entityId), operationName, exceptionCode);
    }

    public EntityNotFoundException(String operationName, String exceptionCode, String entityType,
                                   Map<String, Object> filters) {
        super(String.format("%s with filters %s not found", entityType, filters) , operationName, exceptionCode);
    }
}
