package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.model.Cart;
import com.aditya.MegamartProjectAssignment.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    public String addToCart(Cart cart){
        cartRepo.save(cart);
        return "Product Added to Cart Successfully!!!";
    }

    public List<Cart> getCartBySellerName(String sellerName){
        return cartRepo.findBySellerName(sellerName);
    }

    public List<Cart> getCartByProductName(String productName){
        return cartRepo.findByProductName(productName);
    }

    public List<Cart> getAllCartItems(){
        return cartRepo.findAll();
    }

    public Cart updateCartItem(String cartId, int quantity) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart Id not found"));
        cart.setQuantity(quantity);
        cartRepo.save(cart);
        return cart;
    }

    public void removeFromCart(String cartId) {
        cartRepo.deleteById(cartId);
    }
}
