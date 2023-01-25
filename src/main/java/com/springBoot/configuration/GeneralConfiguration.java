package com.springBoot.configuration;

import com.springBoot.Bean.MyBeanWithPropierties;
import com.springBoot.Bean.MyBeanWithPropiertiesImplement;
import com.springBoot.Pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@EnableConfigurationProperties(UserPojo.class)
@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String randomValue;
    @Bean
    public MyBeanWithPropierties myBean(){
        return new MyBeanWithPropiertiesImplement(name, lastName);
    }
}
