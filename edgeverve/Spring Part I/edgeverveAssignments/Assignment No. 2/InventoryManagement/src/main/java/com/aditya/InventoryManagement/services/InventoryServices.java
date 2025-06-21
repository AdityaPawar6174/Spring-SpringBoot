package com.aditya.InventoryManagement.services;

import com.aditya.InventoryManagement.beans.Inventory;
import com.aditya.InventoryManagement.repos.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class InventoryServices implements InventoryServicesInterface {

    @Autowired
    InventoryRepo inventoryRepo;

    @Override
    public void addProduct(Inventory inventory) {
        inventoryRepo.save(inventory);
    }

    @Override
    public Optional<Inventory> findProductById(int productId) {
        return inventoryRepo.findById(productId);
    }

    @Override
    public void updateInventory(int productId) {

        Optional<Inventory> optional = inventoryRepo.findById(productId);
        Inventory inventory = optional.get();
        try
        {
            if (inventory != null){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter New Product Name");
                String newProductName = sc.next();
                System.out.println("Enter New Product Price");
                int newPrice = sc.nextInt();
                System.out.println("Update Stock Levels");
                int newStockQuantity = sc.nextInt();
                inventory.setProductName(newProductName);
                inventory.setStockQuantity(newStockQuantity);
                inventory.setPrice(newPrice);
                inventoryRepo.save(inventory);
            }
        }
        catch (Exception e){
            System.err.println("Id not found "+e);
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try
        {
            inventoryRepo.deleteById(productId);
            System.out.println("Successfully deleted product id = "+productId);
        }
        catch (Exception e) {
            System.err.println("Product Id "+productId+" not found"+e);
        }
    }

    @Override
    public List<Inventory> getAllProducts() {
        return inventoryRepo.findAll();
    }
}
