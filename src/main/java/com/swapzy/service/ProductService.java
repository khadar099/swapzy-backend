package com.swapzy.service;

import com.swapzy.model.Product;
import com.swapzy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Method to get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to get a product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Method to create or update a product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Method to delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
