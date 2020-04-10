package com.example.crud;

import com.example.crud.service.CustomerService;
import com.example.crud.service.ItemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.crud"})
@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CrudApplication.class, args);

		ItemService itemService = applicationContext.getBean(ItemService.class);
		itemService.saveSomeItems();

		CustomerService customerService = applicationContext.getBean(CustomerService.class);
		customerService.saveSomeCustomers();
	}

}
