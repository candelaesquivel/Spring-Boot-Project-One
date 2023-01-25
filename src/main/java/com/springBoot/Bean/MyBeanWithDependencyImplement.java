package com.springBoot.Bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int num =1;
        System.out.println(myOperation.sum(num));
        System.out.println("Print with dependency");
    }
}
