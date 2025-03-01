package com.example.GroceryManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId; // Auto-incrementing customer ID

    @Column(nullable = false)
    private String name; // Customer name

    @Column(nullable = false)
    private String contact; // Customer contact number

    @Column(nullable = false, unique = true)
    private String email; // Customer email address (unique)

    @Column(nullable = false)
    private Long productId; // Foreign key to the product

    @Column(nullable = false)
    private Double totalCartAmount; // Total cart amount

    @Column(columnDefinition = "TEXT")
    private String imageUrl; // URL of the customer's image

    // Getters and Setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getTotalCartAmount() {
        return totalCartAmount;
    }

    public void setTotalCartAmount(Double totalCartAmount) {
        this.totalCartAmount = totalCartAmount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
