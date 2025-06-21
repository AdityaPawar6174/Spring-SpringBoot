package com.aditya.Assignment1.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final PaymentService paymentService;

    @Autowired // Constructor Injection
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        System.out.println("Order Placed using OrderService...");
        System.out.println(paymentService.processPayment());
    }
}
