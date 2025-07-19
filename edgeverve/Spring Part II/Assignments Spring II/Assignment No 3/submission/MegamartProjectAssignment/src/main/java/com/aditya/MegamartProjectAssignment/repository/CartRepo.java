package com.aditya.MegamartProjectAssignment.repository;

import com.aditya.MegamartProjectAssignment.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, String> {
    List<Cart> findBySellerName(String sellerName);
    List<Cart> findByProductName(String productName);
}
