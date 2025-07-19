package com.aditya.MegamartProjectAssignment.controller;

import com.aditya.MegamartProjectAssignment.model.Wishlist;
import com.aditya.MegamartProjectAssignment.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    WishlistService service;

    @PostMapping("/add")
    public ResponseEntity<String> addToWishlist(@RequestBody Wishlist wishlist){
        String result = service.addToWishList(wishlist);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFromWishList(@PathVariable("id") String id){
        service.removeFromWishlist(id);
        return ResponseEntity.ok("WishList Item with id "+id+" is deleted Successfully!!!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Wishlist>> getWishlistItems() {
        return ResponseEntity.ok(service.getAllWishListItems());
    }
}
