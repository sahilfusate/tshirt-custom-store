package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

   @Override
public void run(String... args) throws Exception {
    productRepository.deleteAll(); // Clean slate

    productRepository.saveAll(Arrays.asList(
        // Electronics
        new Product("Kindle Paperwhite", 139.99, "https://images-na.ssl-images-amazon.com/images/I/61S84uG0uYL._AC_SX679_.jpg", "Waterproof e-reader", "Electronics", 4.8),
        new Product("Wireless Headphones", 199.99, "https://images.pexels.com/photos/3394651/pexels-photo-3394651.jpeg?auto=compress&cs=tinysrgb&w=600", "Noise cancelling", "Electronics", 4.8),
        new Product("Gaming Keyboard", 89.50, "https://images.pexels.com/photos/2106216/pexels-photo-2106216.jpeg?auto=compress&cs=tinysrgb&w=600", "Mechanical RGB", "Electronics", 4.5),
        new Product("Smart Watch", 249.99, "https://images.pexels.com/photos/4370382/pexels-photo-4370382.jpeg?auto=compress&cs=tinysrgb&w=600", "Fitness tracker", "Electronics", 4.6),

        // Shoes
        new Product("Running Shoes", 85.00, "https://images.pexels.com/photos/2529148/pexels-photo-2529148.jpeg?auto=compress&cs=tinysrgb&w=600", "Lightweight sneakers", "Shoes", 4.5),
        new Product("Leather Sneakers", 75.00, "https://images.pexels.com/photos/1464625/pexels-photo-1464625.jpeg?auto=compress&cs=tinysrgb&w=600", "Classic white", "Shoes", 4.2),
        new Product("Hiking Boots", 120.99, "https://images.pexels.com/photos/601170/pexels-photo-601170.jpeg?auto=compress&cs=tinysrgb&w=600", "Rugged terrain", "Shoes", 4.7),
        new Product("Formal Loafers", 95.00, "https://images.pexels.com/photos/298863/pexels-photo-298863.jpeg?auto=compress&cs=tinysrgb&w=600", "Premium leather", "Shoes", 4.4),

        // Books
        new Product("The Great Gatsby", 15.99, "https://images.pexels.com/photos/1907785/pexels-photo-1907785.jpeg?auto=compress&cs=tinysrgb&w=600", "Hardcover classic", "Books", 4.9),
        new Product("Italian Cookbook", 24.00, "https://images.pexels.com/photos/159866/books-book-pages-read-literature-159866.jpeg?auto=compress&cs=tinysrgb&w=600", "Masterpiece recipes", "Books", 4.6),
        new Product("History of Time", 12.50, "https://images.pexels.com/photos/2049422/pexels-photo-2049422.jpeg?auto=compress&cs=tinysrgb&w=600", "Science classic", "Books", 4.8),
        new Product("Modern Art Guide", 35.00, "https://images.pexels.com/photos/1181671/pexels-photo-1181671.jpeg?auto=compress&cs=tinysrgb&w=600", "Visual history", "Books", 4.7),

        // Add these 6 new products to your existing list
        new Product("Bluetooth Speaker", 59.99, "https://images.pexels.com/photos/1190298/pexels-photo-1190298.jpeg?auto=compress&cs=tinysrgb&w=600", "Portable waterproof", "Electronics", 4.7),
        new Product("USB-C Hub", 29.99, "https://images.pexels.com/photos/5412217/pexels-photo-5412217.jpeg?auto=compress&cs=tinysrgb&w=600", "Multi-port adapter", "Electronics", 4.3),
        new Product("Running Socks", 12.00, "https://images.pexels.com/photos/1036936/pexels-photo-1036936.jpeg?auto=compress&cs=tinysrgb&w=600", "Moisture-wicking", "Shoes", 4.6),
        new Product("Cotton T-Shirt", 19.99, "https://images.pexels.com/photos/991509/pexels-photo-991509.jpeg?auto=compress&cs=tinysrgb&w=600", "Soft organic cotton", "Clothing", 4.4),
        new Product("Canvas Backpack", 45.00, "https://images.pexels.com/photos/1337753/pexels-photo-1337753.jpeg?auto=compress&cs=tinysrgb&w=600", "Durable travel bag", "Accessories", 4.5),
        new Product("Coffee Mug", 9.99, "https://images.pexels.com/photos/433285/pexels-photo-433285.jpeg?auto=compress&cs=tinysrgb&w=600", "Ceramic heat-safe", "Home", 4.8)
    ));
}
}