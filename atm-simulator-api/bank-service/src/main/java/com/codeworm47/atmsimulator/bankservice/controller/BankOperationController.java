package com.codeworm47.atmsimulator.bankservice.controller;

import com.codeworm47.atmsimulator.bankservice.model.dto.operation.BalanceOperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.BalanceOperationResult;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.WithdrawDepositOperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.WithdrawDepositOperationResult;
import com.codeworm47.atmsimulator.bankservice.model.entities.account.AccountTransactionType;
import com.codeworm47.atmsimulator.bankservice.service.bankOperation.OperationConstants;
import com.codeworm47.atmsimulator.bankservice.service.bankOperation.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.codeworm47.atmsimulator.bankservice.service.bankOperation.OperationConstants.*;

@RestController
@RequestMapping("/bank/operation")
public class BankOperationController {
    OperationService operationService;

    @PostMapping(value ="/getBalance")
    public BalanceOperationResult getBalance(@RequestBody BalanceOperationParams balanceOperationParams){
        return (BalanceOperationResult)operationService.doOperation(OPERATION_NAME_GET_BALANCE,
                AccountTransactionType.Neutral, balanceOperationParams,
                BalanceOperationParams.class, BalanceOperationResult.class);
    }

    @PostMapping(value ="/withdraw")
    public WithdrawDepositOperationResult withdraw(@RequestBody WithdrawDepositOperationParams withdrawDepositOperationParams){
        return (WithdrawDepositOperationResult)operationService.doOperation(OPERATION_NAME_WITHDRAW,
                AccountTransactionType.Debit, withdrawDepositOperationParams,
                WithdrawDepositOperationParams.class, WithdrawDepositOperationResult.class);
    }

    @PostMapping(value ="/deposit")
    public WithdrawDepositOperationResult deposit(@RequestBody WithdrawDepositOperationParams withdrawDepositOperationParams){
        return (WithdrawDepositOperationResult)operationService.doOperation(OPERATION_NAME_DEPOSIT,
                AccountTransactionType.Credit, withdrawDepositOperationParams,
                WithdrawDepositOperationParams.class, WithdrawDepositOperationResult.class);
    }

    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
}
