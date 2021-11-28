package com.codeworm47.atmsimulator.bankservice.service.security;

import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;
import com.codeworm47.atmsimulator.bankservice.util.DateUtils;
import com.codeworm47.atmsimulator.bankservice.util.Hashing;
import org.springframework.stereotype.Service;

@Service
public class PinNumberTokenService extends TokenService {

    @Override
    public UserAuthenticationMechanism getAuthMechanism() {
        return UserAuthenticationMechanism.PinNumber;
    }
    @Override
    public TokenOutputModel generateToken(TokenInputModel tokenModel) {
        CreditCard creditCard = creditCardRepository.findByCardNumber(tokenModel.getCardNumber());
        String hashedPin = Hashing.sha256Hex(tokenModel.getPinNumber());
        if (hashedPin.equals(creditCard.getHashedPin())){
            return new TokenOutputModel("123", DateUtils.date(2022,1,1));
        }
        return null;
    }
}
