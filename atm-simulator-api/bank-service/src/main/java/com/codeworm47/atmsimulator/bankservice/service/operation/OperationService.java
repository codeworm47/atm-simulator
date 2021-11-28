package com.codeworm47.atmsimulator.bankservice.service.operation;

import com.codeworm47.atmsimulator.bankservice.exception.operational.OperationalException;
import com.codeworm47.atmsimulator.bankservice.factory.BankOperationFactory;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.OutOperation;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    BankOperationFactory<? extends OperationParams, ? extends OperationResult> bankOperationFactory;

    public <TParams extends OperationParams> OperationResult doOperation(String operationName,
                                                                         TParams params,
                                                                         Class<? extends OperationParams> operationParamsClass,
                                                                         Class<? extends OperationResult> operationResultClass) {
        AtomicBankOperation operation = bankOperationFactory.get(operationName, operationParamsClass, operationResultClass);
        try {
            return operation.doOperation(params);
        } catch (OperationalException exception) {
            return null;
        }
    }

    @Autowired
    public void setBankOperationFactory(BankOperationFactory<? extends OperationParams, ? extends OperationResult> bankOperationFactory) {
        this.bankOperationFactory = bankOperationFactory;
    }
}
