package com.codeworm47.atmsimulator.bankservice.service.security;

import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCardStatus;
import com.codeworm47.atmsimulator.bankservice.util.DateUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.security.SignatureException;

@Service
public class JwtService {
    @Value("${JWT_SECRET}")
    private String jwtSecretKey;

    @Value("${TOKEN_EXPIRY_SECONDS}")
    private int tokenExpirySeconds;

    public String generateToken(String creditCardNumber,
                                String hashedCreditCardPinNumber, CreditCardStatus creditCardStatus){

        return Jwts.builder().setSubject("User")
                .setIssuer("Bank_Service").setIssuedAt(DateUtils.nowUtc())
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .setExpiration(DateUtils.addSecondToNow(tokenExpirySeconds))
                .claim("creditCardNumber", creditCardNumber)
                .claim("creditCardStatus", creditCardStatus)
                .claim("hashedCreditCardPinNumber", hashedCreditCardPinNumber)
                .compact();
    }

    public Claims decodeToken(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtSecretKey)
                    .parseClaimsJws(jwt).getBody();
        } catch (RuntimeException exception){
            //For Signature exception etc
            return null;
        }

    }
}
