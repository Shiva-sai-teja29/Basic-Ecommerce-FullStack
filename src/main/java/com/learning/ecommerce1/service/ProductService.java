package com.learning.ecommerce1.service;

import com.learning.ecommerce1.dto.ProductDTO;
import com.learning.ecommerce1.model.Product;
import com.learning.ecommerce1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Convert Product Entity to DTO
    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(product);
    }

    // Get All Products as DTOs
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Products by Category ID as DTOs
    public List<ProductDTO> productsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
