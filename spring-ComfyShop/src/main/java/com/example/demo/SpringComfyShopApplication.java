package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.User;
import com.service.UserServiceImpl;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan("com")
public class SpringComfyShopApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext ctx = 
		SpringApplication.run(SpringComfyShopApplication.class, args);
//		UserServiceImpl service = (UserServiceImpl) ctx.getBean(UserServiceImpl.class);
//		service.addUser(new User("aslam@gmail.com", "secret", "Aslam M.N", "ROLE_USER", "123 street, kpm", false));
	}
}