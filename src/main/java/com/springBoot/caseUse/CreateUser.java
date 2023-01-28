package com.springBoot.caseUse;

import com.springBoot.Entity.User;
import com.springBoot.Service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;
    public CreateUser(UserService userService) {
        this.userService = userService;
    }


    public User save(User newUser) {
        return userService.save(newUser);
    }
}
