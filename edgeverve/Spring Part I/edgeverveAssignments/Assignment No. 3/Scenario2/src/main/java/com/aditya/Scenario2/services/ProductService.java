package com.aditya.Scenario2.services;

import com.aditya.Scenario2.beans.Product;
import com.aditya.Scenario2.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // Add methods for CRUD operations on Product
    public void addProduct(Product product) {
        productRepo.save(product);
    }
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product returnProduct(Product product){
        return product;
    }

}
