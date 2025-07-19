package com.aditya.MegamartProjectAssignment.controller;

import com.aditya.MegamartProjectAssignment.model.Order;
import com.aditya.MegamartProjectAssignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        orderService.placeOrder(order);
        return ResponseEntity.ok("Order Placed Successfully...!\n\n"+order.toString());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/cancelOrder/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable String id){
        boolean isCancelled = orderService.cancelOrder(id);
        if (isCancelled) {
            return ResponseEntity.ok("Order with ID " + id + " has been cancelled successfully.");
        } else {
            return ResponseEntity.status(404).body("Order with ID " + id + " not found.");
        }
    }

}
