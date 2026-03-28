package com.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // This magic line allows: localhost:8080/api/products/category/Electronics
    List<Product> findByCategory(String category);
    
}