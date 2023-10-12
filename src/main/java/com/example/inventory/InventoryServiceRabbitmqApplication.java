package com.example.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InventoryServiceRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceRabbitmqApplication.class, args);
	}

}
