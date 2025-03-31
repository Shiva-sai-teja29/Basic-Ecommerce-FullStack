package com.learning.ecommerce1.controller;

import com.learning.ecommerce1.model.Product;
import com.learning.ecommerce1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/category/{categoryId}")
    public List<Product> productsByCategoryId(@PathVariable Long categoryId){
        return productService.productsByCategoryId(categoryId);
    }
}
