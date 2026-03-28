package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Crucial for your HTML to talk to Java
public class ApiController {

    @Autowired
    private ProductRepository productRepository;

    // 1. Get ALL products (Amazon's Home Page)
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Get products by category (Amazon's Category Filters)
    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }

    // 3. Simple Welcome Message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to ShoPperZ!";
    }
}