package com.aditya.MegamartProjectAssignment.controller;

import com.aditya.MegamartProjectAssignment.model.Order;
import com.aditya.MegamartProjectAssignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
        Order placedOrder = orderService.addOrder(order);
        return ResponseEntity.ok(placedOrder);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        Iterable<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

}
