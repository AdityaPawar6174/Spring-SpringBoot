package com.aditya.MegamartProjectAssignment.controller;

import com.aditya.MegamartProjectAssignment.model.Product;
import com.aditya.MegamartProjectAssignment.repository.ProductRepo;
import com.aditya.MegamartProjectAssignment.service.ProductService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepo productRepo;

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "Product Added Successfully..."+product.toString();
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable("id") String id){
        return productService.getProductById(id);
    }

    @GetMapping("/get/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
