package com.codeworm47.atmsimulator.bankservice.controller;

import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;
import com.codeworm47.atmsimulator.bankservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @PostMapping("/token")
    public TokenOutputModel getTokenByPinNumber(@RequestBody TokenInputModel tokenInputModel){
        tokenInputModel.setAuthenticationMechanism(UserAuthenticationMechanism.PinNumber);
        return userService.getToken(tokenInputModel);
    }

    @PostMapping("/token/fingerprint")
    public TokenOutputModel getTokenByPinNumber(@RequestPart("cardNumber") String creditCardNumber,
                                                @RequestPart("fingerPrintFile") MultipartFile fingerPrintFile) throws IOException {
        TokenInputModel tokenInputModel = new TokenInputModel(UserAuthenticationMechanism.FingerPrint,
                creditCardNumber, fingerPrintFile.getBytes());
        return userService.getToken(tokenInputModel);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
