package com.springBoot;

import com.springBoot.Bean.MyBean;
import com.springBoot.Bean.MyBeanWithDependency;
import com.springBoot.Bean.MyBeanWithPropierties;
import com.springBoot.Component.ComponentDependency;
import com.springBoot.Entity.User;
import com.springBoot.Pojo.UserPojo;
import com.springBoot.Repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(this.getClass());
	private final ComponentDependency componentDependency;
	private final MyBean myBean;

	private final  MyBeanWithDependency myBeanWithDependency;

	private final  MyBeanWithPropierties myBeanWithPropierties;

	private  final UserRepository userRepository;

	private final  UserPojo userPojo;
	public SpringProjectApplication(@Qualifier("componentImplementTwo")
									ComponentDependency componentDependency ,
									MyBean myBean,
									MyBeanWithDependency myBeanWithDependency,
									MyBeanWithPropierties myBeanWithPropierties,
									UserPojo userPojo,
									UserRepository userRepository

	){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.myBeanWithPropierties=myBeanWithPropierties;
		this.userPojo=userPojo;
		this.userRepository=userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Examples();
		SaveUsersInDb();
		getInfoJpqlFromUser();
	}

	private void getInfoJpqlFromUser(){
		LOGGER.info(
				"USUARIO FILTRADO POR EMAIL :  " + userRepository.findMyUserByEmail("john@domain.com")

						.orElseThrow(()-> new RuntimeException("No se encontro un usuario")));

		userRepository.findName("John")
				.stream()
				.forEach(user -> LOGGER.info("USUARIO BUSCADO POR NOMBRE "+ user));

		userRepository.findNameLike("%Joh%")
				.stream()
				.forEach(user -> LOGGER.info("USUARIO BUSCADO POR NOMBRE LIKE "+ user));

	}
	private void SaveUsersInDb() {
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 03, 15));
		User user2 = new User("Julie", "julie@domain.com", LocalDate.of(2021, 03, 20));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 03, 25));

		List<User> list = Arrays.asList( user1, user3, user2);
		list.stream().forEach(userRepository::save);

	}

	private void Examples(){
		componentDependency.Saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithPropierties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getAge() + "-" + userPojo.getPassword());

		try{
			int value =10;
			LOGGER.debug("value :: "+value);

		}catch(Exception e){
			LOGGER.error("Error dividing for zero" + e.getMessage());
		}
	}
}
