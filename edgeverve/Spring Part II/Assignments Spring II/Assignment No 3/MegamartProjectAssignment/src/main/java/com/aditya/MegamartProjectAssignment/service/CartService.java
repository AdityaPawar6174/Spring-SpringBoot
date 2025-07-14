package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.model.Cart;
import com.aditya.MegamartProjectAssignment.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    public String addToCart(String cartId, String productName, String sellerName, int quantity, Double cartOffer){
        Cart cart = new Cart();

        cart.setCartId(cartId);
        cart.setProductName(productName);
        cart.setSellerName(sellerName);
        cart.setQuantity(quantity);
        cart.setCartOffer_price(cartOffer);

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
}
