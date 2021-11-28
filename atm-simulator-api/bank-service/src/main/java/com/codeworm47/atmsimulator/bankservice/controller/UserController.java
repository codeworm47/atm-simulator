package com.codeworm47.atmsimulator.bankservice.controller;

import com.codeworm47.atmsimulator.bankservice.model.dto.TokenInputModel;
import com.codeworm47.atmsimulator.bankservice.model.dto.TokenOutputModel;
import com.codeworm47.atmsimulator.bankservice.model.entities.user.UserAuthenticationMechanism;
import com.codeworm47.atmsimulator.bankservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @PostMapping("/token")
    public TokenOutputModel getTokenByPinNumber(@RequestBody TokenInputModel tokenInputModel){
        tokenInputModel.setAuthenticationMechanism(UserAuthenticationMechanism.PinNumber);
        return userService.getToken(tokenInputModel);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
