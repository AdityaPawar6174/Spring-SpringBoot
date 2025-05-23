package com.aditya.Assignment1.config;

import com.aditya.Assignment1.beans.OrderService;
import com.aditya.Assignment1.beans.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.aditya")
public class AppConfig {

    @Bean
    public PaymentService paymentService(){
        return new PaymentService();
    }

    @Bean
    public OrderService orderService(){
        return new OrderService(paymentService());
    }

}

