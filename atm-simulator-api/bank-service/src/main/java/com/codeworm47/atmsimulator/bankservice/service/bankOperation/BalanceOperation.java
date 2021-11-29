package com.codeworm47.atmsimulator.bankservice.service.bankOperation;

import com.codeworm47.atmsimulator.bankservice.model.dto.operation.BalanceOperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.BalanceOperationResult;
import org.springframework.stereotype.Component;

@Component
public class BalanceOperation implements AtomicBankOperation<BalanceOperationParams, BalanceOperationResult> {
    @Override
    public String getOperationName() {
        return OperationConstants.OPERATION_NAME_GET_BALANCE;
    }

    @Override
    public Class<?> getParamType() {
        return BalanceOperationParams.class;
    }

    @Override
    public Class<?> getResultType() {
        return BalanceOperationResult.class;
    }

    @Override
    public BalanceOperationResult doOperation(BalanceOperationParams params) {
        BalanceOperationResult res = new BalanceOperationResult();
        res.setBalance(params.getAccount().getBalance());
        return res;
    }
}
