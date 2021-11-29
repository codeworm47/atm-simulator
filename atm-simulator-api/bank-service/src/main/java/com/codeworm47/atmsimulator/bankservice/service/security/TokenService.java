package com.codeworm47.atmsimulator.bankservice.service.security;

import com.codeworm47.atmsimulator.bankservice.exception.operational.EntityNotFoundException;
import com.codeworm47.atmsimulator.bankservice.exception.operational.ExceptionConstants;
import com.codeworm47.atmsimulator.bankservice.exception.operational.InvalidOperationForStateException;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCardStatus;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;
import com.codeworm47.atmsimulator.bankservice.persistence.AccountRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.CreditCardRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public abstract class TokenService {
    @Value("${TOKEN_EXPIRY_SECONDS}")
    protected int tokenExpirySeconds;

    protected UserRepository userRepository;
    protected AccountRepository accountRepository;
    protected CreditCardRepository creditCardRepository;
    protected JwtService jwtService;

    public abstract UserAuthenticationMechanism getAuthMechanism();
    public abstract TokenOutputModel generateToken(TokenInputModel tokenModel);



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
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }
}
