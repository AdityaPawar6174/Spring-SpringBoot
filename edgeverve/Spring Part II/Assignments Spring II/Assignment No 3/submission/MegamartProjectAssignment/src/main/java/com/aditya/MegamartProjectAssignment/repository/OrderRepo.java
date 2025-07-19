package com.aditya.MegamartProjectAssignment.repository;

import com.aditya.MegamartProjectAssignment.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, String> {
}
