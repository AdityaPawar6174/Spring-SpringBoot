package com.aditya.Assignment1.main;

import com.aditya.Assignment1.beans.OrderService;
import com.aditya.Assignment1.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}
}
