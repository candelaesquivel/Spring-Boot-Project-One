package com.springBoot.Component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {
    @Override
    public void Saludar() {
        System.out.print("Hi from Component");
    }
}
