package com.codeworm47.atmsimulator.bankservice.service.security;

import com.codeworm47.atmsimulator.bankservice.exception.operational.ExceptionConstants;
import com.codeworm47.atmsimulator.bankservice.exception.operational.creditcard.WrongPinNumberException;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;
import com.codeworm47.atmsimulator.bankservice.service.bankOperation.CreditCardService;
import com.codeworm47.atmsimulator.bankservice.service.bankOperation.OperationConstants;
import com.codeworm47.atmsimulator.bankservice.util.DateUtils;
import com.codeworm47.atmsimulator.bankservice.util.Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinNumberTokenService extends TokenService {
    final static Logger LOGGER = LogManager.getLogger(PinNumberTokenService.class);
    CreditCardService creditCardService;

    @Override
    public UserAuthenticationMechanism getAuthMechanism() {
        return UserAuthenticationMechanism.PinNumber;
    }

    @Override
    public TokenOutputModel generateToken(TokenInputModel tokenModel) {
        String operationName = OperationConstants.OPERATION_NAME_LOGIN_BY_PIN_NUMBER;
        CreditCard creditCard = creditCardService.validateAndGetCreditCardByCardId(operationName, tokenModel.getCardNumber());
        String hashedPin = Hashing.sha256Hex(tokenModel.getPinNumber());
        if (!hashedPin.equals(creditCard.getHashedPin())){
            throw new WrongPinNumberException(operationName, ExceptionConstants.CREDIT_CARD_WRONG_PIN_NUMBER,
                    creditCard.getCardNumber(), tokenModel.getPinNumber(), creditCard);
        }
        String token = jwtService.generateToken(creditCard.getCardNumber(), hashedPin, creditCard.getStatus(), getAuthMechanism());
        LOGGER.info("generated token for {} : {}", creditCard.getCardNumber(), token);
        return new TokenOutputModel(token, DateUtils.addSecondToNow(tokenExpirySeconds), creditCard.getId());
    }

    @Autowired
    public void setCreditCardService(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }
}
