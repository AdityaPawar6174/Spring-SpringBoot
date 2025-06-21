package com.aditya.InventoryManagement.services;

import com.aditya.InventoryManagement.beans.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryServicesInterface {

    public void addProduct(Inventory inventory);

    public Optional<Inventory> findProductById(int productId);

    public void updateInventory(int productId);

    public void deleteProduct(int productId);

    public List<Inventory> getAllProducts();

}
