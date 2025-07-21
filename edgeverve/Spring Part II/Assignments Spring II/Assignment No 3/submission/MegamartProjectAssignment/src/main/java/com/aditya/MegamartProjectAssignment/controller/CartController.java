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
public ResponseEntity<String> addToCart(@RequestBody Cart cart){
    String result = cartService.addToCart(cart);
    return ResponseEntity.ok(result +"\n"+cart.toString());
}

    @GetMapping("/all")
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

    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> updateCartItem(@PathVariable String cartId,
                                               @RequestParam int quantity) {
        Cart updatedCart = cartService.updateCartItem(cartId, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<String> removeFromCart(@PathVariable String cartId) {
        cartService.removeFromCart(cartId);
        return ResponseEntity.ok("Deleted successfully");
    }

}
