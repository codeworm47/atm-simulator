package com.codeworm47.atmsimulator.bankservice.factory;

import com.codeworm47.atmsimulator.bankservice.exception.logical.BankOperationNotFoundException;
import com.codeworm47.atmsimulator.bankservice.exception.logical.ServiceImplementationNotfoundException;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationResult;
import com.codeworm47.atmsimulator.bankservice.service.bankOperation.AtomicBankOperation;
import com.codeworm47.atmsimulator.bankservice.service.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankOperationFactory<TParams extends OperationParams, TResult extends OperationResult> {
    List<AtomicBankOperation<TParams, TResult>> bankOperations;

    public AtomicBankOperation<TParams, TResult> get(String operationName,
                                                                                         Class<? extends OperationParams> operationParamsClass,
                                                                                         Class<? extends OperationResult> operationResultClass){
        if (CollectionUtils.isEmpty(bankOperations)){
            throw new ServiceImplementationNotfoundException("bankOperations is null/empty",
                    TokenService.class.getSimpleName());
        }

        List<AtomicBankOperation<TParams, TResult>> bankOperationsByOperationName = bankOperations
                .stream().filter(p->p.getOperationName().equals(operationName)).collect(Collectors.toList());
        if (bankOperationsByOperationName.isEmpty()){
            throw new BankOperationNotFoundException(operationName);
        }
        Optional<AtomicBankOperation<TParams, TResult>> operation = bankOperations
                .stream()
                .filter(p->p.getOperationName().equals(operationName)
                        && p.getParamType().equals(operationParamsClass)
                        && p.getResultType().equals(operationResultClass))
                .findFirst();
        if (operation.isEmpty()){
            throw new BankOperationNotFoundException(operationName,
                    operationParamsClass.getSimpleName(), operationResultClass.getSimpleName());
        }
        return operation.get();
    }

    @Autowired
    public void setBankOperations(List<AtomicBankOperation<TParams, TResult>> bankOperations) {
        this.bankOperations = bankOperations;
    }
}
