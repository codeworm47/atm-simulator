package com.codeworm47.atmsimulator.bankservice.service.bankOperation;

import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationResult;

public interface AtomicBankOperation<TParams extends OperationParams, TResult extends OperationResult> {
    String getOperationName();
    Class<?> getParamType();
    Class<?> getResultType();
    TResult doOperation(TParams params);
}
