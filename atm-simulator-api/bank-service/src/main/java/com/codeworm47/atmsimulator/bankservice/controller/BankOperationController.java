package com.codeworm47.atmsimulator.bankservice.controller;

import com.codeworm47.atmsimulator.bankservice.model.dto.operation.BalanceOperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.BalanceOperationResult;
import com.codeworm47.atmsimulator.bankservice.service.operation.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/operation")
public class BankOperationController {
    OperationService operationService;


    @GetMapping(value ="/getBalance", produces = "application/json")
    public BalanceOperationResult getBalance(){
        return (BalanceOperationResult)operationService.doOperation("getBalance",
                new BalanceOperationParams(), BalanceOperationParams.class, BalanceOperationResult.class);
    }

    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
}
