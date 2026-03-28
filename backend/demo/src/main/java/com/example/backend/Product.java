package com.example.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String imageUrl;
    private String info;
    private String category;
    private double rating;

    public Product() {}

    public Product(String name, double price, String imageUrl, String info, String category, double rating) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.info = info;
        this.category = category;
        this.rating = rating;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public String getInfo() { return info; }
    public String getCategory() { return category; }
    public double getRating() { return rating; }
}