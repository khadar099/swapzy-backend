package com.swapzy.repository;

import com.swapzy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom queries can be added here if needed
    // For example: 
    // List<Product> findByName(String name);
}
