package com.codeworm47.atmsimulator.bankservice.service;

import com.codeworm47.atmsimulator.bankservice.factory.TokenServiceFactory;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.persistence.AccountRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.CreditCardRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private CreditCardRepository creditCardRepository;
    private TokenServiceFactory tokenServiceFactory;

    public TokenOutputModel getToken(TokenInputModel tokenInputModel){

        return tokenServiceFactory.get(tokenInputModel.getAuthenticationMechanism()).generateToken(tokenInputModel);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setCreditCardRepository(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Autowired
    public void setTokenServiceFactory(TokenServiceFactory tokenServiceFactory) {
        this.tokenServiceFactory = tokenServiceFactory;
    }
}
