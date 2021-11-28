package com.codeworm47.atmsimulator.bankservice.service;

import com.codeworm47.atmsimulator.bankservice.factory.TokenServiceFactory;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private TokenServiceFactory tokenServiceFactory;

    public TokenOutputModel getToken(TokenInputModel tokenInputModel){

        return tokenServiceFactory.get(tokenInputModel.getAuthenticationMechanism()).generateToken(tokenInputModel);
    }

    @Autowired
    public void setTokenServiceFactory(TokenServiceFactory tokenServiceFactory) {
        this.tokenServiceFactory = tokenServiceFactory;
    }
}
