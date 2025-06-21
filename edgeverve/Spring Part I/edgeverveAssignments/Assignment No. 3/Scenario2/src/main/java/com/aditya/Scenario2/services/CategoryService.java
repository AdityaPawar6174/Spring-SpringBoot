package com.aditya.Scenario2.services;

import com.aditya.Scenario2.beans.Category;
import com.aditya.Scenario2.beans.Product;
import com.aditya.Scenario2.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Product> getProductsInCategory(int categoryId) {
        return categoryRepo.findById(categoryId)
                .map(Category::getProducts)
                .orElse(Collections.emptyList());
    }

}