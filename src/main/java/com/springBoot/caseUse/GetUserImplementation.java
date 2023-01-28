package com.springBoot.caseUse;

import com.springBoot.Entity.User;
import com.springBoot.Service.UserService;

import java.util.List;

public class GetUserImplementation implements GetUser{

    private UserService userService;

    public GetUserImplementation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
