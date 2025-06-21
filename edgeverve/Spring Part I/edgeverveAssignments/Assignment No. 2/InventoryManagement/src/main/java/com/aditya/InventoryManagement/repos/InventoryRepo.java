package com.aditya.InventoryManagement.repos;

import com.aditya.InventoryManagement.beans.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
}
