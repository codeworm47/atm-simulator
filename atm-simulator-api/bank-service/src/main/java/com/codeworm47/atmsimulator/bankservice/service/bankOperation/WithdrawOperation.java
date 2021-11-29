package com.codeworm47.atmsimulator.bankservice.service.bankOperation;

import com.codeworm47.atmsimulator.bankservice.model.dto.operation.WithdrawDepositOperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.WithdrawDepositOperationResult;

public class WithdrawOperation  implements AtomicBankOperation<WithdrawDepositOperationParams, WithdrawDepositOperationResult> {
    @Override
    public String getOperationName() {
        return OperationConstants.OPERATION_NAME_WITHDRAW;
    }

    @Override
    public Class<?> getParamType() {
        return null;
    }

    @Override
    public Class<?> getResultType() {
        return null;
    }

    //TODO Unfinished
    @Override
    public WithdrawDepositOperationResult doOperation(WithdrawDepositOperationParams params) {
        return null;
    }
}
