package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.model.Cart;
import com.aditya.MegamartProjectAssignment.model.Order;
import com.aditya.MegamartProjectAssignment.repository.CartRepo;
import com.aditya.MegamartProjectAssignment.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CartRepo cartRepo;

    public Order placeOrder(Order order){
        // checking if the cart items exist before placing the order
        Optional<Cart> optionalCart = cartRepo.findById(order.getOrderId());

        if (optionalCart.isPresent()) {
            order.setOrdered_date(new Date());
            order.setOrder_status("Pending");
            return orderRepo.save(order);
        }
        else {
            throw new IllegalArgumentException("Cart item not found for given Order ID: " + order.getOrderId());
        }
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public boolean cancelOrder(String id) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setOrder_status("Cancelled");
            orderRepo.save(order);
            return true;
        } else {
            return false; // Order not found
        }
    }
}

