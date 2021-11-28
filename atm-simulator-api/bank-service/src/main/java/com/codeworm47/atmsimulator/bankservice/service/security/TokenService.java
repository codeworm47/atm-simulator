package com.codeworm47.atmsimulator.bankservice.service.security;

import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;

public interface TokenService {
    UserAuthenticationMechanism getAuthMechanism();
    TokenOutputModel generateToken(TokenInputModel tokenModel);
}
