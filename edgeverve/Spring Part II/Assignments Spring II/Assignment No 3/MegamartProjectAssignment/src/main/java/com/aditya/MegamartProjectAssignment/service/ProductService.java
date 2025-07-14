package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.model.Product;
import com.aditya.MegamartProjectAssignment.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public Product getProductById(String id){
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product Id not Found"));
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

}
