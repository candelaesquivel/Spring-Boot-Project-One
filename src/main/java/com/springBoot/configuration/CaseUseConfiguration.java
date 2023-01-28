package com.springBoot.configuration;

import com.springBoot.Service.UserService;
import com.springBoot.caseUse.GetUser;
import com.springBoot.caseUse.GetUserImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplementation(userService);
    }
}
