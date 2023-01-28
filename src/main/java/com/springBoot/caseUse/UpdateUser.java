package com.springBoot.caseUse;

import com.springBoot.Entity.User;
import com.springBoot.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;
    public UpdateUser(UserService userService) {
        this.userService = userService;
    }


    public ResponseEntity<User> update(User newUser, Long id) {
        return new ResponseEntity<>(userService.update(newUser ,id), HttpStatus.OK);
    }
}
