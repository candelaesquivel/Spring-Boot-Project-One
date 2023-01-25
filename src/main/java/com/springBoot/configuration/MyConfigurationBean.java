package com.springBoot.configuration;

import com.springBoot.Bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplementTwo();
    }
    @Bean
    public MyOperation beanOperationTwo(){
        return new MyOperartionImplemention();
    }

    @Bean
    public MyBeanWithDependency beanOperationThree(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
