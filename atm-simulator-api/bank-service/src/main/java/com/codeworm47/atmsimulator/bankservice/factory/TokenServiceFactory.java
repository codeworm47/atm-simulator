package com.codeworm47.atmsimulator.bankservice.factory;

import com.codeworm47.atmsimulator.bankservice.exception.logical.ServiceImplementationNotfoundException;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;
import com.codeworm47.atmsimulator.bankservice.service.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceFactory {
    List<TokenService> tokenServices;

    public TokenService get(UserAuthenticationMechanism authenticationMechanism){
        if (CollectionUtils.isEmpty(tokenServices)){
            throw new ServiceImplementationNotfoundException("tokenServices is null/empty",
                    TokenService.class.getSimpleName());
        }
        Optional<TokenService> service = tokenServices
                .stream()
                .filter(p->p.getAuthMechanism().equals(authenticationMechanism))
                .findAny();
        if (service.isEmpty()){
            String className = TokenService.class.getSimpleName();
            throw new ServiceImplementationNotfoundException(
                    String.format("no service implementation of %s found for authenticationMechanism : %s",
                            className, authenticationMechanism), className);
        }
        return service.get();
    }

    @Autowired
    public void setTokenServices(List<TokenService> tokenServices) {
        this.tokenServices = tokenServices;
    }
}
