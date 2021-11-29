package com.codeworm47.atmsimulator.bankservice.service;

import com.codeworm47.atmsimulator.bankservice.exception.operational.creditcard.WrongPinNumberException;
import com.codeworm47.atmsimulator.bankservice.factory.TokenServiceFactory;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCardStatus;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.LoginAttempt;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.LoginAttemptStatus;
import com.codeworm47.atmsimulator.bankservice.persistence.CreditCardRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.LoginAttemptRepository;
import com.codeworm47.atmsimulator.bankservice.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private CreditCardRepository creditCardRepository;
    private TokenServiceFactory tokenServiceFactory;
    private LoginAttemptRepository loginAttemptRepository;
    public TokenOutputModel getToken(TokenInputModel tokenInputModel){
        LoginAttempt loginAttempt = new LoginAttempt();
        TokenOutputModel token = null;
        try {
            loginAttempt.setDate(DateUtils.nowUtc());
            loginAttempt.setCreditCardNumber(tokenInputModel.getCardNumber());
            token = tokenServiceFactory.get(tokenInputModel.getAuthenticationMechanism()).generateToken(tokenInputModel);
            loginAttempt.setCreditCardId(token.getCreditCardId());
        } catch (WrongPinNumberException wrongPinNumberException){
            //TODO LOG
            CreditCard creditCard = wrongPinNumberException.getCreditCard();
            String creditCardId = creditCard.getId();
            loginAttempt.setCreditCardId(creditCardId);

            lockCreditCardIfUnsuccessfulLoginCountExceeded(creditCard);

        } catch (RuntimeException exception){
            loginAttempt.setStatus(LoginAttemptStatus.Error);
        }
        finally {
            loginAttemptRepository.save(loginAttempt);
        }
        return token;

    }
    private void lockCreditCardIfUnsuccessfulLoginCountExceeded(CreditCard creditCard){
        long todayUnsuccessfulLoginCount = loginAttemptRepository.countByCreditCardIdAndStatusAndDate_Day(creditCard.getId(),
                LoginAttemptStatus.Failed, DateUtils.nowUtc());
        //TODO read 3 from env var
        if (todayUnsuccessfulLoginCount == 3){
            //TODO LOG
            creditCard.setStatus(CreditCardStatus.Locked);
            creditCardRepository.save(creditCard);
        }

    }
    @Autowired
    public void setTokenServiceFactory(TokenServiceFactory tokenServiceFactory) {
        this.tokenServiceFactory = tokenServiceFactory;
    }

    @Autowired
    public void setLoginAttemptRepository(LoginAttemptRepository loginAttemptRepository) {
        this.loginAttemptRepository = loginAttemptRepository;
    }

    @Autowired
    public void setCreditCardRepository(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
}
