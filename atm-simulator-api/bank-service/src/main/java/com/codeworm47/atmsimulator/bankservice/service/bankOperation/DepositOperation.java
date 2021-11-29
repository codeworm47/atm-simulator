package com.codeworm47.atmsimulator.bankservice.service.bankOperation;

import com.codeworm47.atmsimulator.bankservice.model.dto.operation.WithdrawDepositOperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.WithdrawDepositOperationResult;

public class DepositOperation implements AtomicBankOperation<WithdrawDepositOperationParams, WithdrawDepositOperationResult> {
    @Override
    public String getOperationName() {
        return OperationConstants.OPERATION_NAME_DEPOSIT;
    }

    @Override
    public Class<?> getParamType() {
        return WithdrawDepositOperationParams.class;
    }

    @Override
    public Class<?> getResultType() {
        return WithdrawDepositOperationResult.class;
    }

    //TODO Unfinished.
    @Override
    public WithdrawDepositOperationResult doOperation(WithdrawDepositOperationParams params) {
        return null;
    }
}
