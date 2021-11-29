package com.codeworm47.atmsimulator.bankservice.service.security;

import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;
import org.springframework.stereotype.Service;

@Service
//TODO Unfinished
public class FingerPrintTokenService extends TokenService {
    @Override
    public UserAuthenticationMechanism getAuthMechanism() {
        return UserAuthenticationMechanism.FingerPrint;
    }

    @Override
    public TokenOutputModel generateToken(TokenInputModel tokenModel) {
        return null;
    }
}
