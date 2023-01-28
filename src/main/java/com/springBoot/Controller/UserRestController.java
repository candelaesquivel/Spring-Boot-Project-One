package com.springBoot.Controller;

import com.springBoot.Entity.User;
import com.springBoot.caseUse.GetUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create , get , delete ,update

    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    // localhost:8081/app/api/users/  --> POSTMAN
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }
}
