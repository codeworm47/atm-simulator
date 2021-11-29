package com.codeworm47.atmsimulator.bankservice.service.bankOperation;

import com.codeworm47.atmsimulator.bankservice.exception.operational.OperationalException;
import com.codeworm47.atmsimulator.bankservice.factory.BankOperationFactory;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationParams;
import com.codeworm47.atmsimulator.bankservice.model.dto.operation.OperationResult;
import com.codeworm47.atmsimulator.bankservice.model.entities.EntityRef;
import com.codeworm47.atmsimulator.bankservice.model.entities.account.Account;
import com.codeworm47.atmsimulator.bankservice.model.entities.account.AccountTransaction;
import com.codeworm47.atmsimulator.bankservice.model.entities.account.AccountTransactionStatus;
import com.codeworm47.atmsimulator.bankservice.model.entities.account.AccountTransactionType;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;
import com.codeworm47.atmsimulator.bankservice.persistence.AccountRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.AccountTransactionRepository;
import com.codeworm47.atmsimulator.bankservice.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//TODO Unfinished
public class OperationService {
    BankOperationFactory<? extends OperationParams, ? extends OperationResult> bankOperationFactory;
    CreditCardService creditCardService;
    AccountTransactionRepository accountTransactionRepository;

    public <TParams extends OperationParams> OperationResult doOperation(String operationName, AccountTransactionType transactionType,
                                                                         TParams params,
                                                                         Class<? extends OperationParams> operationParamsClass,
                                                                         Class<? extends OperationResult> operationResultClass) {
        AtomicBankOperation operation = bankOperationFactory.get(operationName, operationParamsClass, operationResultClass);
        AccountTransaction accountTransaction = new AccountTransaction();

        try {
            //TODO LOG Beginning
            CreditCard creditCard = creditCardService.validateAndGetCreditCardByCardId(operationName, params.getCreditCardNumber());

            accountTransaction.setAccountRef(creditCard.getAccountRef());
            accountTransaction.setOperation(operationName);
            accountTransaction.setCreditCardRef(new EntityRef(creditCard.getId(), CreditCard.class.getSimpleName()));
            accountTransaction.setDate(DateUtils.nowUtc());
            accountTransaction.setType(transactionType);

            OperationResult operationResult = operation.doOperation(params);

            accountTransaction.setStatus(AccountTransactionStatus.Completed);

            return operationResult;
            //TODO LOG Ending
        } catch (OperationalException exception) {
            //TODO LOG Exception
            //TODO initiate rollback if money deducted
            accountTransaction.setStatus(AccountTransactionStatus.RollBacked);
            throw exception;
        }
        catch (RuntimeException exception) {
            //TODO LOG Exception
            accountTransaction.setStatus(AccountTransactionStatus.Failed);
            throw exception;
        }
        finally {
            accountTransactionRepository.save(accountTransaction);
        }
    }

    @Autowired
    public void setBankOperationFactory(BankOperationFactory<? extends OperationParams, ? extends OperationResult> bankOperationFactory) {
        this.bankOperationFactory = bankOperationFactory;
    }

    @Autowired
    public void setAccountTransactionRepository(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Autowired
    public void setCreditCardService(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }
}
