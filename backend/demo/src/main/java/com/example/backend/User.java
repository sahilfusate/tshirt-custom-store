package com.example.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String fullName;

    // Constructors, Getters, and Setters
    public User() {}
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    @Transient
    private String otp;
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}
