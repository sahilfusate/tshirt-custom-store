package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // In-memory OTP storage: Email -> OTP
    private static final Map<String, String> otpStorage = new HashMap<>();

    @PostMapping("/request-otp")
    public String requestOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        if (email == null || email.isEmpty()) {
            return "Email is required";
        }
        
        // Generate 6-digit OTP
        String otp = String.format("%06d", new Random().nextInt(999999));
        otpStorage.put(email, otp);
        
        System.out.println("==================================================");
        System.out.println("Verification Code for " + email + ": " + otp);
        System.out.println("==================================================");
        
        return "OTP sent successfully!";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists!";
        }
        
        String storedOtp = otpStorage.get(user.getEmail());
        if (storedOtp == null || !storedOtp.equals(user.getOtp())) {
            return "Invalid or expired Verification Code";
        }

        userRepository.save(user);
        otpStorage.remove(user.getEmail()); // Clear OTP after use
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        String storedOtp = otpStorage.get(user.getEmail());
        if (storedOtp == null || !storedOtp.equals(user.getOtp())) {
            return "Invalid or expired Verification Code";
        }

        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
        if(foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            otpStorage.remove(user.getEmail()); // Clear OTP after use
            return "Login successful!";
        }
        return "Invalid email or password";
    }
}