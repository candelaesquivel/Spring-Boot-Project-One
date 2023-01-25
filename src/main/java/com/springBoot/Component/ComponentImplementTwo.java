package com.springBoot.Component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementTwo implements ComponentDependency{
    @Override
    public void Saludar() {
        System.out.println("Hi from component TWO ");
    }
}
