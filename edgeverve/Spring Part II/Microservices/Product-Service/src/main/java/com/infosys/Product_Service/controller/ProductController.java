package com.infosys.Product_Service.controller;


import com.infosys.Product_Service.model.Product;
import com.infosys.Product_Service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @GetMapping("/allProducts")
    public List<Product> displayAllProducts(){
        return productRepo.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> displayProductById(@PathVariable("productId") Long productId){
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("product ot found with ID: "+productId));
        return ResponseEntity.ok(product);
    }
}
