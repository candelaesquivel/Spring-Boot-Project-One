package com.springBoot;

import com.springBoot.Bean.MyBean;
import com.springBoot.Bean.MyBeanWithDependency;
import com.springBoot.Bean.MyBeanWithPropierties;
import com.springBoot.Component.ComponentDependency;
import com.springBoot.Pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(this.getClass());
	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithPropierties myBeanWithPropierties;

	private UserPojo userPojo;
	public SpringProjectApplication(@Qualifier("componentImplementTwo")
									ComponentDependency componentDependency ,
									MyBean myBean,
									MyBeanWithDependency myBeanWithDependency,
									MyBeanWithPropierties myBeanWithPropierties,
									UserPojo userPojo

	){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.myBeanWithPropierties=myBeanWithPropierties;
		this.userPojo=userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.Saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithPropierties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getAge() + "-" + userPojo.getPassword());

		try{
			int value =10/0;
			LOGGER.debug("value :: "+value);

		}catch(Exception e){
			LOGGER.error("Error dividing for cero" + e.getMessage());
		}
	}
}
