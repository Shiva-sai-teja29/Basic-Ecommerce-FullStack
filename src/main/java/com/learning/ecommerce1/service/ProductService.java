package com.learning.ecommerce1.service;

import com.learning.ecommerce1.model.Product;
import com.learning.ecommerce1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> productsByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }
}
