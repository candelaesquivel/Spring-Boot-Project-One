package com.springBoot;

import com.springBoot.Bean.MyBean;
import com.springBoot.Bean.MyBeanWithDependency;
import com.springBoot.Component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;

	public SpringProjectApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency , MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency=myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.Saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}
}
