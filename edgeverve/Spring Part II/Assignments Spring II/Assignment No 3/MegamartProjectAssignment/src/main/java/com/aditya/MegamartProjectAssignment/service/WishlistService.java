package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.model.Wishlist;
import com.aditya.MegamartProjectAssignment.repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishlistService {

    @Autowired
    WishlistRepo wishlistRepo;

    public String addToWishList(Wishlist wishlist){
        try {
            wishlistRepo.save(wishlist);
        }
        catch (Exception e) {
            return "Error while adding product to WishList: " + e.getMessage();
        }

        return "Product Added to WishList Successfully!!!";
    }

    public String deleteFromWishlist(String wishId){
        try {
            wishlistRepo.deleteById(wishId);
        }
        catch (Exception e) {
            return "Error while adding product to WishList: " + e.getMessage();
        }

        return "Product removed from WishList Successfully!!!";
    }

    public List<Wishlist> getAllWishListItems() {
        return wishlistRepo.findAll();
    }
}
