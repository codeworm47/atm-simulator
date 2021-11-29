package com.codeworm47.atmsimulator.bankservice;

import com.codeworm47.atmsimulator.bankservice.model.entities.EntityRef;
import com.codeworm47.atmsimulator.bankservice.model.entities.account.Account;
import com.codeworm47.atmsimulator.bankservice.model.entities.account.AccountStatus;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCard;
import com.codeworm47.atmsimulator.bankservice.model.entities.card.CreditCardStatus;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.*;
import com.codeworm47.atmsimulator.bankservice.persistence.AccountRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.CreditCardRepository;
import com.codeworm47.atmsimulator.bankservice.persistence.UserRepository;
import com.codeworm47.atmsimulator.bankservice.util.CodecUtils;
import com.codeworm47.atmsimulator.bankservice.util.DateUtils;
import com.codeworm47.atmsimulator.bankservice.util.Hashing;
import com.codeworm47.atmsimulator.bankservice.util.ResourceReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class DataSeeder implements CommandLineRunner {
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private CreditCardRepository creditCardRepository;

    private final static Logger LOGGER = LogManager.getLogger(DataSeeder.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.debug("begin seeding");
        User user = createUser();
        Account account = createAccount(user);
        createCreditCard(account);
        LOGGER.debug("end seeding");

    }

    private User createUser() throws Exception {

        LOGGER.debug("creating user");
        String nationalId = "123456";
        User user;
        user = userRepository.findByNationalId(nationalId);
        if (user != null){
            return user;
        }
        user = new User();
        user.setName("Johny");
        user.setLastName("Killer");
        user.setStatus(UserStatus.Active);
        user.setPreferredAuthenticationMechanism(UserAuthenticationMechanism.PinNumber);
        user.setIdentificationInfo(Collections.singletonList(new UserIdentificationInfo("NationalId",nationalId ,
                DateUtils.date(2022, 1, 1))));
        String filePath = "samples/fingerprint.jpg";
        byte[] fingerprintBytes = ResourceReader.readBytes(filePath);
        String base64 = CodecUtils.toBase64URI(fingerprintBytes);
        String hashedBase64 = Hashing.sha256Hex(base64);
        user.setBiometricInfo(Collections.singletonList(new UserBiometricInfo("FingerPrint", hashedBase64, filePath)));

        userRepository.insert(user);
        LOGGER.debug("user created : id -> {}", user.getId());
        return user;
    }

    private Account createAccount(User user){
        LOGGER.debug("creating account");
        Account account;
        String accountId = "11223344556677";
        account = accountRepository.findByAccountId(accountId);
        if (account != null){
            return account;
        }
        account = new Account();
        account.setAccountId(accountId);
        account.setName(user.getFullName());
        account.setStatus(AccountStatus.Active);
        account.setUserRef(new EntityRef(user.getId(), user.getClass().getSimpleName()));
        accountRepository.insert(account);
        LOGGER.debug("account : id -> {}", account.getId());
        return account;
    }

    private CreditCard createCreditCard(Account account){
        LOGGER.debug("creating credit card");
        CreditCard creditCard;
        String cardNumber = "1122445599776611";
        creditCard = creditCardRepository.findByCardNumber(cardNumber);
        if (creditCard != null){
            return creditCard;
        }
        creditCard = new CreditCard();
        creditCard.setCardNumber(cardNumber);
        creditCard.setIssuedDate(DateUtils.nowUtc());
        creditCard.setStatus(CreditCardStatus.Active);
        creditCard.setAccountRef(new EntityRef(account.getId(), account.getClass().getSimpleName()));
        String pin = "3344";
        creditCard.setHashedPin(Hashing.sha256Hex(pin));
        creditCard.setUserRef(account.getUserRef());
        creditCardRepository.insert(creditCard);
        LOGGER.debug("creditCard : id -> {}", creditCard.getId());
        return creditCard;
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
}
