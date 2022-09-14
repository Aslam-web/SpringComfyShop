package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.Product;
import com.model.User;
import com.service.ProductServiceImpl;
import com.service.UserServiceImpl;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
@ComponentScan("com")
public class SpringComfyShopApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext ctx = 
		SpringApplication.run(SpringComfyShopApplication.class, args);
//		UserServiceImpl service = (UserServiceImpl) ctx.getBean(UserServiceImpl.class);
//		service.addUser(new User("aslamhit21009@gmail.com", "123", "Aslam M.N", "ROLE_USER", "123 street, kpm", false));
//		
//		ProductServiceImpl productService = ctx.getBean(ProductServiceImpl.class);
//		productService.addProduct(new Product("Long Jeans", "The best quality jeans from Adidas", 1300, 23, "https://thumbs.dreamstime.com/b/blue-jeans-isolated-white-background-blue-jeans-isolated-white-126824335.jpg"));
//		productService.addProduct(new Product("T-Shirt", "Cheap t-shirt at high quality", 900,21,"https://upload.wikimedia.org/wikipedia/commons/2/24/Blue_Tshirt.jpg"));
//		productService.addProduct(new Product("Shirt", "Polythene shirt with latest fashion touch", 945, 1,"https://5.imimg.com/data5/GD/WI/MY-3624146/mens-full-sleeve-shirt-500x500.jpg"));
//		productService.addProduct(new Product("Vesti", "Colourfull vesti yet traditional style", 880, 8,"https://www.rssonline.in/3250-thickbox_default/vesti-mayil-7-kan-blue-color.jpg"));

		System.out.println("Spring initialized");
	}
}

// red tie
// https://www.collinsdictionary.com/images/full/tie_171498722_1000.jpg