package com.springBoot.Bean;

import org.apache.juli.logging.LogFactory;
import org.apache.juli.logging.Log;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Inside the method print with dependency");
        int num =1;
        LOGGER.debug("The number debug :  " +num );
        System.out.println(myOperation.sum(num));
        System.out.println("Print with dependency");
    }
}
