package com.codeworm47.atmsimulator.bankservice.service.bankOperation;

import com.codeworm47.atmsimulator.bankservice.exception.operational.EntityNotFoundException;
import com.codeworm47.atmsimulator.bankservice.exception.operational.ExceptionConstants;
import com.codeworm47.atmsimulator.bankservice.exception.operational.InvalidOperationForStateException;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCardStatus;
import com.codeworm47.atmsimulator.bankservice.persistence.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreditCardService {
    private CreditCardRepository creditCardRepository;
    public CreditCard validateAndGetCreditCardByCardId(String operationName, String cardNumber){
        CreditCard creditCard = creditCardRepository.findByCardNumber(cardNumber);
        if (creditCard == null){
            throw new EntityNotFoundException(operationName,
                    ExceptionConstants.CREDIT_CARD_NOT_FOUND_BY_CARD_ID, CreditCard.class.getSimpleName(),
                    Map.of("cardNumber", cardNumber));
        }
        if (!CreditCardStatus.Active.equals(creditCard.getStatus())
                && !CreditCardStatus.Created.equals(creditCard.getStatus())){
            throw new InvalidOperationForStateException(operationName,
                    ExceptionConstants.CREDIT_CARD_INVALID_STATE_FOR_OPERATION, CreditCard.class.getSimpleName(),
                    creditCard.getId(), creditCard.getStatus().toString(), "Created,Active");
        }
        return creditCard;
    }
    @Autowired
    public void setCreditCardRepository(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
}
