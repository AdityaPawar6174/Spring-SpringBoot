package com.aditya.Admin_Rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AdminRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminRestApplication.class, args);
	}


}
