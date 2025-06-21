package com.aditya.Scenario2.services;

import com.aditya.Scenario2.beans.Order;
import com.aditya.Scenario2.beans.User;
import com.aditya.Scenario2.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    // Add methods for CRUD operations on Order
    public void addOrder(Order order) {
        orderRepo.save(order);
    }
    public Order getOrderById(int id) {
        return orderRepo.findById(id).orElse(null);
    }
    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }
    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

}
