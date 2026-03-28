package com.example.backend;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
    private List<Product> cartItems = new ArrayList<>();

    @PostMapping("/add")
    public String addToCart(@RequestBody Product product) {
        cartItems.add(product);
        return product.getName() + " added to your cart!";
    }

    @GetMapping("/count")
    public int getCartCount() {
        return cartItems.size();
    }

    @GetMapping("/items")
    public List<Product> getCartItems(){
        return cartItems; // This returns the list to the sidebar
    }

    @DeleteMapping("/remove/{index}")
    public void removeItem(@PathVariable int index) {
    if (index >= 0 && index < cartItems.size()) {
        cartItems.remove(index);
        System.out.println("Removed item at index: " + index);
    }
}
}