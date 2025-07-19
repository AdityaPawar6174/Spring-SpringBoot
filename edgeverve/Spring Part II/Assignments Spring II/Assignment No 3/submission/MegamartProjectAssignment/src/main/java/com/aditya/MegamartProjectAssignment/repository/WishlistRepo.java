package com.aditya.MegamartProjectAssignment.repository;

import com.aditya.MegamartProjectAssignment.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, String> {
}
