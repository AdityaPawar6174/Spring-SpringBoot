package com.aditya.Assignment1.beans;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public String processPayment() {
        return "Payment processed using PaymentService...";
    }
}
