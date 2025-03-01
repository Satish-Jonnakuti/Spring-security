package com.example.GroceryManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId; // Auto-incrementing cart ID

    @Column(nullable = false)
    private Long customerId; // Foreign key to the customer

    @Column(nullable = false)
    private Long productId; // Foreign key to the product

    @Column(nullable = false)
    private Integer quantity = 1; // Quantity of the product in the cart

    @Column(nullable = false)
    private String addedDate; // Date when the product was added to the cart

    // Getters and Setters

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
}
