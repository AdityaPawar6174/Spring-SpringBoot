package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.model.Cart;
import com.aditya.MegamartProjectAssignment.model.Order;
import com.aditya.MegamartProjectAssignment.repository.CartRepo;
import com.aditya.MegamartProjectAssignment.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CartRepo cartRepo;

    public Order addOrder(Order order){
        // checking if the cart items exist before placing the order
        Optional<Cart> optionalCart = cartRepo.findById(order.getOrderId());

        if (optionalCart.isPresent()) {
            return orderRepo.save(order);
        }
        else {
            throw new IllegalArgumentException("Cart item not found for given Order ID: " + order.getOrderId());
        }
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}

