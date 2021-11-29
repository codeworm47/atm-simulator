package com.codeworm47.atmsimulator.bankservice.config.security;

import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCardStatus;
import com.codeworm47.atmsimulator.bankservice.service.security.JwtService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private JwtService jwtService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        //
    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        Object token = usernamePasswordAuthenticationToken.getCredentials();
        if (token == null){
            throw new UsernameNotFoundException("Authorization header is missing");
        }
        Claims claims = jwtService.decodeToken(token.toString());
        if (claims == null || claims.isEmpty() ||
                !claims.containsKey("creditCardNumber") ||
                !claims.containsKey("creditCardStatus") ||
                !claims.containsKey("hashedValue") ||
                !claims.containsKey("authenticationMechanism")
        ){
            throw new UsernameNotFoundException(String.format("invalid token : %s", token));
        }
        CreditCardStatus creditCardStatus = CreditCardStatus.valueOf(claims.get("creditCardStatus").toString());
        String creditCardNumber = claims.get("creditCardNumber").toString();
        if (!CreditCardStatus.Created.equals(creditCardStatus) && !CreditCardStatus.Active.equals(creditCardStatus)){
            throw new UsernameNotFoundException(String.format("invalid credit card status : %s, card number : %s",
                    creditCardStatus, creditCardNumber));
        }
        return new User(creditCardNumber, claims.get("hashedValue").toString(),
                AuthorityUtils.createAuthorityList("USER"));
    }

    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }
}
