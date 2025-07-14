package com.aditya.MegamartProjectAssignment.controller;

import com.aditya.MegamartProjectAssignment.model.Cart;
import com.aditya.MegamartProjectAssignment.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestParam String cartId,
                                            @RequestParam String productName,
                                            @RequestParam String sellerName,
                                            @RequestParam int quantity,
                                            @RequestParam Double cartOffer){
        String result = cartService.addToCart(cartId, productName, sellerName, quantity, cartOffer);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> viewAllCartItems(){
        return ResponseEntity.ok(cartService.getAllCartItems());
    }

    @GetMapping("/product")
    public ResponseEntity<List<Cart>> viewByProduct(@RequestParam String productName) {
        return ResponseEntity.ok(cartService.getCartByProductName(productName));
    }

    @GetMapping("/seller")
    public ResponseEntity<List<Cart>> viewBySeller(@RequestParam String sellerName) {
        return ResponseEntity.ok(cartService.getCartBySellerName(sellerName));
    }

}
